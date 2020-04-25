package com.zzr.mall.dto;

import javax.validation.constraints.NotNull;

public class PropertyValueUpdateParam {
    @NotNull
    private Integer id;
    @NotNull
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
