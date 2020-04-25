package com.zzr.mall.result;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class CommonPage<T> {
    private int pageNum;
    private int pageSize;
    private int totalPage;
    private long total;
    private List<T> list;

    public static<T> CommonPage<T> getPage(List<T> list){
        CommonPage<T> commonPage = new CommonPage<>();
        PageInfo<T> pageInfo = new PageInfo<>(list);
        commonPage.setList(pageInfo.getList());
        commonPage.setPageNum(pageInfo.getPageNum());
        commonPage.setPageSize(pageInfo.getPageSize());
        commonPage.setTotalPage(pageInfo.getPages());
        commonPage.setTotal(pageInfo.getTotal());
        return commonPage;
    }

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

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
