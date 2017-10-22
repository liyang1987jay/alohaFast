package com.aloha.alohaFast.core.annotion;

import java.lang.annotation.*;

/**
 * @author liyang
 * @packageNaem com.aloha.alohaFast.core.annotion
 * @fileName Permission
 * @description
 * @date 2017-10-22 22:23
 *  Copyright (c) 2014-2017 山东安合信达电子科技有限公司 版权所有 
 *  shandong aloha CO.,LTD. All Rights Reserved. 
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Permission {
    String[] value() default {};
}
