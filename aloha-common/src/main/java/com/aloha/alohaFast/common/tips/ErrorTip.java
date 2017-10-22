package com.aloha.alohaFast.common.tips;

import com.aloha.alohaFast.common.exception.BizExceptionEnum; /**
 * 返回给前台的错误信息
 * @author liyang
 * @packageNaem com.aloha.alohaFast.base.tips
 * @fileName ErrorTip
 * @description
 * @date 2017-10-14 15:32
 *  Copyright (c) 2014-2017 山东安合信达电子科技有限公司 版权所有 
 *  shandong aloha CO.,LTD. All Rights Reserved. 
 */
public class ErrorTip extends Tip {

    public ErrorTip(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ErrorTip(BizExceptionEnum bizExceptionEnum) {
        this.code = bizExceptionEnum.getCode();
        this.message = bizExceptionEnum.getMessage();
    }
}
