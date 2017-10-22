package com.aloha.alohaFast.core.aop;

import com.aloha.alohaFast.common.constant.dictmap.base.AbstractDictMap;
import com.aloha.alohaFast.common.constant.dictmap.factory.DictMapFactory;
import com.aloha.alohaFast.common.log.AlohaLog;
import com.aloha.alohaFast.common.util.Contrast;
import com.aloha.alohaFast.core.annotion.log.BussinessLog;
import com.aloha.alohaFast.core.log.LogManager;
import com.aloha.alohaFast.core.log.LogObjectHolder;
import com.aloha.alohaFast.core.log.factory.LogTaskFactory;
import com.aloha.alohaFast.core.shiro.ShiroKit;
import com.aloha.alohaFast.core.shiro.ShiroUser;
import com.aloha.alohaFast.common.support.HttpKit;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author liyang
 * @packageNaem com.aloha.alohaFast.core.aop
 * @fileName LogAop
 * @description
 * @date 2017-10-22 22:17
 *  Copyright (c) 2014-2017 山东安合信达电子科技有限公司 版权所有 
 *  shandong aloha CO.,LTD. All Rights Reserved. 
 */
public class LogAop {
    private Logger log = AlohaLog.get(this.getClass());

    @Pointcut(value = "@annotation(com.aloha.alohaFast.core.annotion.log.BussinessLog)")
    public void cutService() {
    }

    @Around("cutService()")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {

        //先执行业务
        Object result = point.proceed();

        try {
            handle(point);
        } catch (Exception e) {
            log.error("日志记录出错!", e);
        }

        return result;
    }

    private void handle(ProceedingJoinPoint point) throws Exception {

        //获取拦截的方法名
        Signature sig = point.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = point.getTarget();
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        String methodName = currentMethod.getName();

        //如果当前用户未登录，不做日志
        ShiroUser user = ShiroKit.getUser();
        if (null == user) {
            return;
        }

        //获取拦截方法的参数
        String className = point.getTarget().getClass().getName();
        Object[] params = point.getArgs();

        //获取操作名称
        BussinessLog annotation = currentMethod.getAnnotation(BussinessLog.class);
        String bussinessName = annotation.value();
        String key = annotation.key();
        String dictClass = annotation.dict();

        StringBuilder sb = new StringBuilder();
        for (Object param : params) {
            sb.append(param);
            sb.append(" & ");
        }

        //如果涉及到修改,比对变化
        String msg;
        if (bussinessName.indexOf("修改") != -1 || bussinessName.indexOf("编辑") != -1) {
            Object obj1 = LogObjectHolder.me().get();
            Map<String, String> obj2 = HttpKit.getRequestParameters();
            msg = Contrast.contrastObj(dictClass, key, obj1, obj2);
        } else {
            Map<String, String> parameters = HttpKit.getRequestParameters();
            AbstractDictMap dictMap = DictMapFactory.createDictMap(dictClass);
            msg = Contrast.parseMutiKey(dictMap,key,parameters);
        }

        LogManager.me().executeLog(LogTaskFactory.bussinessLog(user.getId(), bussinessName, className, methodName, msg));
    }
}
