package com.aloha.alohaFast.common.constant.dictmap.base;

import java.util.HashMap;

/**
 * @author liyang
 * @packageNaem com.aloha.alohaFast.common.constant.dictmap.base
 * @fileName AbstractDictMap
 * @description
 * @date 2017-10-22 23:03
 *  Copyright (c) 2014-2017 山东安合信达电子科技有限公司 版权所有 
 *  shandong aloha CO.,LTD. All Rights Reserved. 
 */
public abstract class AbstractDictMap {
    protected HashMap<String, String> dictory = new HashMap<>();
    protected HashMap<String, String> fieldWarpperDictory = new HashMap<>();

    public AbstractDictMap(){
        put("id","主键id");
        init();
        initBeWrapped();
    }

    /**
     * @describe:
     * @description 初始化字段英文名称和中文名称对应的字典
     * @author liyang
     * @return 
     * @creat_date: 2017/10/22
     * @creat_time: 23:04
     **/
    
    public abstract void init();

   /**
    * @methed_name:
    * @description 初始化需要被包装的字段(例如:性别为1:男,2:女,需要被包装为汉字)
    * @author liyang
    * @return 
    * @creat_date: 2017/10/22
    * @creat_time: 23:04
    **/
   
    protected abstract void initBeWrapped();

    public String get(String key) {
        return this.dictory.get(key);
    }

    public void put(String key, String value) {
        this.dictory.put(key, value);
    }

    public String getFieldWarpperMethodName(String key){
        return this.fieldWarpperDictory.get(key);
    }

    public void putFieldWrapperMethodName(String key,String methodName){
        this.fieldWarpperDictory.put(key,methodName);
    }
}
