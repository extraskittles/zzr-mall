package com.zzr.mall.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ProductUpdateParam {
    @NotNull
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String subTitle;
    @NotNull
    private Float originalPrice;
    @NotNull
    private Float promotePrice;
    @NotNull
    private Integer stock;
    @NotNull
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Float getPromotePrice() {
        return promotePrice;
    }

    public void setPromotePrice(Float promotePrice) {
        this.promotePrice = promotePrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
