package com.zzr.mall.model;

public class PropertyValue {
    private Integer id;

    private Integer pid;

    private Integer ptid;

    private String value;

    public PropertyValue(Integer id, Integer pid, Integer ptid, String value) {
        this.id = id;
        this.pid = pid;
        this.ptid = ptid;
        this.value = value;
    }

    public PropertyValue() {
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

    public Integer getPtid() {
        return ptid;
    }

    public void setPtid(Integer ptid) {
        this.ptid = ptid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}