package com.yh.swim.domain;

/**
 * Created by yanhuan1 on 2018/1/20.
 */
public class BasePageCondition extends BaseBussinessDomain {

    /**
     * 当前页
     */
    private int pageNum = 1;

    /**
     * 每页记录数
     */
    private int pageSize = 5;

    private String orderBy;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
