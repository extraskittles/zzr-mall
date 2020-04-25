package com.zzr.mall.Emum;



public enum OrderStatus {
    NOTPAY("未支付"),
    PAIED("已支付"),
    DELIVERING("已发货"),
    RECEIVED("已收货"),
    COMMONETED("已评论");

    private String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
