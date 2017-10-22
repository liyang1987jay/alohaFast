package com.aloha.alohaFast.core.log.factory;

import com.aloha.alohaFast.common.constant.state.LogSucceed;
import com.aloha.alohaFast.common.constant.state.LogType;
import com.aloha.alohaFast.core.persistence.entity.LoginLog;
import com.aloha.alohaFast.core.persistence.entity.OperationLog;

import java.util.Date;

/**
 * @author liyang
 * @packageNaem com.aloha.alohaFast.core.log.factory
 * @fileName LogFactory
 * @description
 * @date 2017-10-22 22:30
 *  Copyright (c) 2014-2017 山东安合信达电子科技有限公司 版权所有 
 *  shandong aloha CO.,LTD. All Rights Reserved. 
 */
public class LogFactory {
   /**
    * @methoe_name:createOperationLog
    * @param: 
    * @describe: 创建操作日志
    * @description 
    * @author liyang
    * @return 
    * creat_date: 2017/10/22
    * creat_time: 22:30
    **/
   
    public static OperationLog createOperationLog(LogType logType, Integer userId, String bussinessName, String clazzName, String methodName, String msg, LogSucceed succeed) {
        OperationLog operationLog = new OperationLog();
        operationLog.setLogtype(logType.getMessage());
        operationLog.setLogname(bussinessName);
        operationLog.setUserid(userId);
        operationLog.setClassname(clazzName);
        operationLog.setMethod(methodName);
        operationLog.setCreatetime(new Date());
        operationLog.setSucceed(succeed.getMessage());
        operationLog.setMessage(msg);
        return operationLog;
    }

   /**
    * @methoe_name:createLoginLog
    * @param: 
    * @describe: T创建登录日志
    * @description 
    * @author liyang
    * @return 
    * creat_date: 2017/10/22
    * creat_time: 22:31
    **/
   
    public static LoginLog createLoginLog(LogType logType, Integer userId, String msg, String ip) {
        LoginLog loginLog = new LoginLog();
        loginLog.setLogname(logType.getMessage());
        loginLog.setUserid(userId);
        loginLog.setCreatetime(new Date());
        loginLog.setSucceed(LogSucceed.SUCCESS.getMessage());
        loginLog.setIp(ip);
        loginLog.setMessage(msg);
        return loginLog;
    }
}
