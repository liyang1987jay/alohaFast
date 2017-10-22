package com.aloha.alohaFast.common.constant.state;

/**
 * @author liyang
 * @packageNaem com.aloha.alohaFast.common.constant
 * @fileName LogType
 * @description
 * @date 2017-10-22 22:45
 *  Copyright (c) 2014-2017 山东安合信达电子科技有限公司 版权所有 
 *  shandong aloha CO.,LTD. All Rights Reserved. 
 */
public enum  LogType {
    LOGIN("登录日志"),
    LOGIN_FAIL("登录失败日志"),
    EXIT("退出日志"),
    EXCEPTION("异常日志"),
    BUSSINESS("业务日志");

    String message;

    LogType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
