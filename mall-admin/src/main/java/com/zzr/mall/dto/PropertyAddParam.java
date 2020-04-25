package com.zzr.mall.dto;


import javax.validation.constraints.NotNull;

public class PropertyAddParam {
    @NotNull
    private Integer cid;
    @NotNull
    private String name;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
