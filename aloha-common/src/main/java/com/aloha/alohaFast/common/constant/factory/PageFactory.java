package com.aloha.alohaFast.common.constant.factory;

import com.aloha.alohaFast.common.support.HttpKit;

import javax.servlet.http.HttpServletRequest;
import com.baomidou.mybatisplus.plugins.Page;
/**
 * @author liyang
 * @packageNaem com.aloha.alohaFast.common.constant.factory
 * @fileName PageFactory
 * @description
 * @date 2017-10-22 22:48
 *  Copyright (c) 2014-2017 山东安合信达电子科技有限公司 版权所有 
 *  shandong aloha CO.,LTD. All Rights Reserved. 
 */
public class PageFactory<T> {
    public Page<T> defaultPage() {
        HttpServletRequest request = HttpKit.getRequest();
        int limit = Integer.valueOf(request.getParameter("limit"));
        int offset = Integer.valueOf(request.getParameter("offset"));
        return new Page<>((offset/limit + 1), limit);
    }
}
