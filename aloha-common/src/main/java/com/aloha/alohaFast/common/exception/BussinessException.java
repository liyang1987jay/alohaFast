package com.aloha.alohaFast.common.exception;

/**
 * @author liyang
 * @packageNaem com.aloha.alohaFast.common.exception
 * @fileName BussinessException
 * @description
 * @date 2017-10-22 22:12
 *  Copyright (c) 2014-2017 山东安合信达电子科技有限公司 版权所有 
 *  shandong aloha CO.,LTD. All Rights Reserved. 
 */
public class BussinessException extends RuntimeException {
    //友好提示的code码
    private int friendlyCode;

    //友好提示
    private String friendlyMsg;

    //业务异常跳转的页面
    private String urlPath;

    public BussinessException(BizExceptionEnum bizExceptionEnum){
        this.friendlyCode = bizExceptionEnum.getCode();
        this.friendlyMsg = bizExceptionEnum.getMessage();
        this.urlPath = bizExceptionEnum.getUrlPath();
    }

    public int getCode() {
        return friendlyCode;
    }

    public void setCode(int code) {
        this.friendlyCode = code;
    }

    public String getMessage() {
        return friendlyMsg;
    }

    public void setMessage(String message) {
        this.friendlyMsg = message;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }
}
