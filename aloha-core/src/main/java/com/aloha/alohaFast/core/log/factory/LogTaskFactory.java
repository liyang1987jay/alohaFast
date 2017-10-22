package com.aloha.alohaFast.core.log.factory;

import com.aloha.alohaFast.common.constant.state.LogSucceed;
import com.aloha.alohaFast.common.constant.state.LogType;
import com.aloha.alohaFast.common.log.AlohaLog;
import com.aloha.alohaFast.common.util.AlohaStringUtil;
import com.aloha.alohaFast.core.db.Db;
import com.aloha.alohaFast.core.log.LogManager;
import com.aloha.alohaFast.core.persistence.dao.LoginLogMapper;
import com.aloha.alohaFast.core.persistence.dao.OperationLogMapper;
import com.aloha.alohaFast.core.persistence.entity.LoginLog;
import com.aloha.alohaFast.core.persistence.entity.OperationLog;
import org.slf4j.Logger;

import java.util.TimerTask;

/**
 * @author liyang
 * @packageNaem com.aloha.alohaFast.core.log.factory
 * @fileName LogTaskFactory
 * @description
 * @date 2017-10-22 23:33
 *  Copyright (c) 2014-2017 山东安合信达电子科技有限公司 版权所有 
 *  shandong aloha CO.,LTD. All Rights Reserved. 
 */
public class LogTaskFactory {
    private static Logger logger = AlohaLog.get((LogManager.class));
    private static LoginLogMapper loginLogMapper = Db.getMapper(LoginLogMapper.class);
    private static OperationLogMapper operationLogMapper = Db.getMapper(OperationLogMapper.class);

    public static TimerTask loginLog(Integer userId, String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                try {
                    LoginLog loginLog = LogFactory.createLoginLog(LogType.LOGIN, userId, null, ip);
                    loginLogMapper.insert(loginLog);
                } catch (Exception e) {
                    logger.error("创建登录日志异常!", e);
                }
            }
        };
    }

    public static TimerTask loginLog(String username, String msg, String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                LoginLog loginLog = LogFactory.createLoginLog(
                        LogType.LOGIN_FAIL, null, "账号:" + username + "," + msg, ip);
                try {
                    loginLogMapper.insert(loginLog);
                } catch (Exception e) {
                    logger.error("创建登录失败异常!", e);
                }
            }
        };
    }

    public static TimerTask exitLog(Integer userId,String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                LoginLog loginLog = LogFactory.createLoginLog(LogType.EXIT, userId, null,ip);
                try {
                    loginLogMapper.insert(loginLog);
                } catch (Exception e) {
                    logger.error("创建退出日志异常!", e);
                }
            }
        };
    }

    public static TimerTask bussinessLog(Integer userId, String bussinessName, String clazzName, String methodName, String msg) {
        return new TimerTask() {
            @Override
            public void run() {
                OperationLog operationLog = LogFactory.createOperationLog(
                        LogType.BUSSINESS, userId, bussinessName, clazzName, methodName, msg, LogSucceed.SUCCESS);
                try {
                    operationLogMapper.insert(operationLog);
                } catch (Exception e) {
                    logger.error("创建业务日志异常!", e);
                }
            }
        };
    }

    public static TimerTask exceptionLog(Integer userId, Exception exception) {
        return new TimerTask() {
            @Override
            public void run() {
                String msg = AlohaStringUtil.getExceptionMsg(exception);
                OperationLog operationLog = LogFactory.createOperationLog(
                        LogType.EXCEPTION, userId, "", null, null, msg, LogSucceed.FAIL);
                try {
                    operationLogMapper.insert(operationLog);
                } catch (Exception e) {
                    logger.error("创建异常日志异常!", e);
                }
            }
        };
    }
}
