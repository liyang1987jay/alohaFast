package com.aloha.alohaFast.common.constant.dictmap.factory;

import com.aloha.alohaFast.common.constant.factory.ConstantFactory;
import com.aloha.alohaFast.common.exception.BizExceptionEnum;
import com.aloha.alohaFast.common.exception.BussinessException;

import java.lang.reflect.Method;

/**
 * @author liyang
 * @packageNaem com.aloha.alohaFast.common.constant.dictmap.factory
 * @fileName DictFieldWarpperFactory
 * @description
 * @date 2017-10-23 0:03
 *  Copyright (c) 2014-2017 山东安合信达电子科技有限公司 版权所有 
 *  shandong aloha CO.,LTD. All Rights Reserved. 
 */
public class DictFieldWarpperFactory {
    public static Object createFieldWarpper(Object field, String methodName) {
        ConstantFactory me = ConstantFactory.me();
        try {
            Method method = ConstantFactory.class.getMethod(methodName, field.getClass());
            Object result = method.invoke(me, field);
            return result;
        } catch (Exception e) {
            try {
                Method method = ConstantFactory.class.getMethod(methodName, Integer.class);
                Object result = method.invoke(me, Integer.parseInt(field.toString()));
                return result;
            } catch (Exception e1) {
                throw new BussinessException(BizExceptionEnum.ERROR_WRAPPER_FIELD);
            }
        }
    }
}
