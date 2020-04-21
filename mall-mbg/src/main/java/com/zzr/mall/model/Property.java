package com.zzr.mall.model;

public class Property {
    private Integer id;

    private Integer cid;

    private String name;

    public Property(Integer id, Integer cid, String name) {
        this.id = id;
        this.cid = cid;
        this.name = name;
    }

    public Property() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        this.name = name == null ? null : name.trim();
    }
}