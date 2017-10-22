package com.aloha.alohaFast.common.constant.dictmap.factory;

import com.aloha.alohaFast.common.constant.dictmap.base.AbstractDictMap;
import com.aloha.alohaFast.common.constant.dictmap.base.SystemDict;
import com.aloha.alohaFast.common.exception.BizExceptionEnum;
import com.aloha.alohaFast.common.exception.BussinessException;

/**
 * @author liyang
 * @packageNaem com.aloha.alohaFast.common.constant.dictmap.factory
 * @fileName DictMapFactory
 * @description
 * @date 2017-10-22 23:08
 *  Copyright (c) 2014-2017 山东安合信达电子科技有限公司 版权所有 
 *  shandong aloha CO.,LTD. All Rights Reserved. 
 */
public class DictMapFactory {
    private static final String basePath = "com.aloha.alohaFast.common.constant.dictmap";

    /**
     * 通过类名创建具体的字典类
     */
    public static AbstractDictMap createDictMap(String className) {
        if("SystemDict".equals(className)){
            return new SystemDict();
        }else{
            try {
                Class<AbstractDictMap> clazz = (Class<AbstractDictMap>) Class.forName(basePath + className);
                return clazz.newInstance();
            } catch (Exception e) {
                throw new BussinessException(BizExceptionEnum.ERROR_CREATE_DICT);
            }
        }
    }
}
