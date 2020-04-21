package com.zzr.mall.model;

public class ProductImage {
    private Integer id;

    private Integer pid;

    private String type;

    public ProductImage(Integer id, Integer pid, String type) {
        this.id = id;
        this.pid = pid;
        this.type = type;
    }

    public ProductImage() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}