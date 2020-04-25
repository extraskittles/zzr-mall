package com.zzr.mall.service;

import com.zzr.mall.dto.PropertyValueUpdateParam;
import com.zzr.mall.model.PropertyValue;

import java.util.List;

public interface PropertyValueService {
    List<PropertyValue> selectByProductId(int productId);
    int delete(int id);
    int insert(PropertyValue propertyValue);
    int update(PropertyValueUpdateParam param);
    int updateMany(List<PropertyValueUpdateParam> params);
}
