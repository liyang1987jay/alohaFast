package com.aloha.alohaFast.common.constant.state;

/**
 * @author liyang
 * @packageNaem com.aloha.alohaFast.common.constant.state
 * @fileName LogSucceed
 * @description
 * @date 2017-10-22 22:46
 *  Copyright (c) 2014-2017 山东安合信达电子科技有限公司 版权所有 
 *  shandong aloha CO.,LTD. All Rights Reserved. 
 */
public enum LogSucceed {
    SUCCESS("成功"),
    FAIL("失败");

    String message;

    LogSucceed(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
