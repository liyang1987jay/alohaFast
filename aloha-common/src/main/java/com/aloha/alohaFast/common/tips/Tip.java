package com.aloha.alohaFast.common.tips;

/**
 * 返回给前台的提示（最终转化为json形式）
 * @author liyang
 * @packageNaem com.aloha.alohaFast.base.tips
 * @fileName Tip
 * @description
 * @date 2017-10-14 15:31
 *  Copyright (c) 2014-2017 山东安合信达电子科技有限公司 版权所有 
 *  shandong aloha CO.,LTD. All Rights Reserved. 
 */
public abstract class Tip {
    protected int code;
    protected String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
