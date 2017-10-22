package com.aloha.alohaFast.common.exception;

import com.aloha.alohaFast.common.util.StrKit;

/**
 * @author liyang
 * @packageNaem com.aloha.alohaFast.common.exception
 * @fileName ToolBoxException
 * @description 工具类初始化异常
 * @date 2017-10-22 23:15
 *  Copyright (c) 2014-2017 山东安合信达电子科技有限公司 版权所有 
 *  shandong aloha CO.,LTD. All Rights Reserved. 
 */
public class ToolBoxException extends RuntimeException{

    private static final long serialVersionUID = 6136064300705742840L;

    public ToolBoxException(Throwable e) {
        super(e.getMessage(), e);
    }

    public ToolBoxException(String message) {
        super(message);
    }

    public ToolBoxException(String messageTemplate, Object... params) {
        super(StrKit.format(messageTemplate, params));
    }

    public ToolBoxException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ToolBoxException(Throwable throwable, String messageTemplate, Object... params) {
        super(StrKit.format(messageTemplate, params), throwable);
    }
}