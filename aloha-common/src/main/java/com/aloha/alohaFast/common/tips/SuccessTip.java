package com.aloha.alohaFast.common.tips;

/**
 * 返回给前台的成功提示
 * @author liyang
 * @packageNaem com.aloha.alohaFast.base.tips
 * @fileName SuccessTip
 * @description
 * @date 2017-10-14 15:30
 *  Copyright (c) 2014-2017 山东安合信达电子科技有限公司 版权所有 
 *  shandong aloha CO.,LTD. All Rights Reserved. 
 */
public class SuccessTip extends Tip {
    public SuccessTip(){
        super.code = 10000;
        super.message = "操作成功";
    }
}
