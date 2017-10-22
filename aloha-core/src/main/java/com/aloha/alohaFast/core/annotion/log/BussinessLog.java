package com.aloha.alohaFast.core.annotion.log;

import java.lang.annotation.*;

/**
 * @author liyang
 * @packageNaem com.aloha.alohaFast.core.annotion.log
 * @fileName BussinessLog
 * @description
 * @date 2017-10-22 22:23
 *  Copyright (c) 2014-2017 山东安合信达电子科技有限公司 版权所有 
 *  shandong aloha CO.,LTD. All Rights Reserved. 
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface BussinessLog {

    /**
     * 业务的名称,例如:"修改菜单"
     */
    String value() default "";

    /**
     * 被修改的实体的唯一标识,例如:菜单实体的唯一标识为"id"
     */
    String key() default "id";

    /**
     * 字典(用于查找key的中文名称和字段的中文名称)
     */
    String dict() default "SystemDict";
}
