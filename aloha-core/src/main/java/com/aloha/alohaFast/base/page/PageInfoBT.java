package com.aloha.alohaFast.base.page;

import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * @author liyang
 * @packageNaem com.aloha.alohaFast.base.page
 * @fileName PageInfoBT
 * @description
 * @date 2017-10-14 15:28
 *  Copyright (c) 2014-2017 山东安合信达电子科技有限公司 版权所有 
 *  shandong aloha CO.,LTD. All Rights Reserved. 
 */
public class PageInfoBT<T> {
    // 结果集
    private List<T> rows;

    // 总数
    private long total;

    public PageInfoBT(Page<T> page) {
        this.rows = page.getRecords();
        this.total = page.getTotal();
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
