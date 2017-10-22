package com.aloha.alohaFast.common.constant.factory;

import com.aloha.alohaFast.common.util.SpringContextHolder;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * @author liyang
 * @packageNaem com.aloha.alohaFast.common.constant.factory
 * @fileName ConstantFactory
 * @description
 * @date 2017-10-23 0:03
 *  Copyright (c) 2014-2017 山东安合信达电子科技有限公司 版权所有 
 *  shandong aloha CO.,LTD. All Rights Reserved. 
 */
@Component
@DependsOn("springContextHolder")
public class ConstantFactory {

    public static ConstantFactory me() {
        return SpringContextHolder.getBean("constantFactory");
    }
}
