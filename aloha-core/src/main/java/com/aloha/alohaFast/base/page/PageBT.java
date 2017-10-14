package com.aloha.alohaFast.base.page;

/**
 * @author liyang
 * @packageNaem com.aloha.alohaFast.base.page
 * @fileName PageBT
 * @description
 * @date 2017-10-14 15:27
 *  Copyright (c) 2014-2017 山东安合信达电子科技有限公司 版权所有 
 *  shandong aloha CO.,LTD. All Rights Reserved. 
 */
public class PageBT {
    private int limit;        // 每页显示个数

    private int offset;    // 查询的偏移量（查询的页数 = offset/limit + 1）

    private String order;    // 排序方式


    public PageBT() {
        super();
    }

    public PageBT(int limit, int offset) {
        super();
        this.limit = limit;
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getPageSize() {
        return this.limit;
    }

    public int getPageNumber() {
        return this.offset / this.limit + 1;
    }

    @Override
    public String toString() {
        return "PageBT [limit=" + limit + ", offset=" + offset + ", order=" + order + "]";
    }

}
