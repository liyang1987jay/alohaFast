package com.aloha.alohaFast.base.db;

import com.aloha.alohaFast.base.util.SpringContextHolder;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 便捷数据库操作类
 * <p>
 * <p>
 * 本类的使用情景：
 * <p>
 * 1.单纯想创建现有的Mapper
 * <p>例如:
 * Db.getMapper(UserLoginMapper.class).selectById("14779707158513204");<br>
 * <p>
 * @author liyang
 * @packageName com.aloha.alohaFast.base.db
 * @fileName Db
 * @description ${DESCRIPTION}
 * @date 2017-10-15 下午9:25
 *  Copyright (c) 2014-2017 山东安合信达电子科技有限公司 版权所有 
 *  shandong aloha CO.,LTD. All Rights Reserved. 
 */
public class Db<T> {
    /**
     * 每个Db类，包装一个Mapper接口,这个clazz就是接口的类类型，例如UserMapper.class
     */
    private Class<T> clazz;

    /**
     * Mapper的父类接口
     */
    private BaseMapper<?> baseMapper;

    /**
     * 私有构造方法，不允许自己创建
     */
    private Db(Class clazz) {
        this.clazz = clazz;
        this.baseMapper = (BaseMapper<?>) SpringContextHolder.getBean(clazz);
    }
    /**
     * @description 创建包含指定mapper的Db工具类,使用本类的第一种用法
     * @author liyang
     * @date 2017/10/15-下午9:44
     * @param
     **/
    public static <T> Db<T> create(Class<T> clazz) {
        return new Db<T>(clazz);
    }
    /**
     * @description 通过一个条件获取数据库中的一条记录(会返回null)
     * @author liyang
     * @date 2017/10/15-下午9:45
     **/
    public <E> E selectOneByCon(String condition, Object value) {
        List<?> results = selectOneByConList(condition, value);
        if (results != null && results.size() > 0) {
            return (E) results.get(0);
        } else {
            return null;
        }
    }
    /**
     * @description 通过一个条件获取一堆记录(会返回null)
     * @author liyang
     * @date 2017/10/15-下午9:49
     **/
    public <E> List<E> selectOneByConList(String condition, Object value) {
        HashMap<String, Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put(condition, value);

        List<E> results = (List<E>) this.baseMapper.selectByMap(conditionMap);
        if (results == null || results.size() == 0) {
            return null;
        } else {
            return results;
        }
    }

}
