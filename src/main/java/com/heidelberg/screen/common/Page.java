package com.heidelberg.screen.common;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * Created by TOPFEEL on 2018/12/25.
 */
@Component
public class Page implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 当前页索引
     */
    private int page = 1;

    /**
     * 每页显示的数据条数
     */
    private int pageSize = 20;

    /**
     * 总条数
     */
    private int total = 0;

    /**
     * 总页数
     */
    private int totalPage = 1;

    /**
     * 排序字段
     */
    private String sort;

    /**
     * 排序方式 ASC DESC
     */
    private String order;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    //刘洋添加，勿删
    public void paging() {
    }

    //刘洋添加，勿删
    public void order() {
    }

    public void setPagingResult(int total, int totalPage) {
    }

    ;

    public void setPagingResult(List list) {
    }

    ;

    public <T> List<T> packResult(List<T> list, int total) {
        return null;
    }

    ;
}

