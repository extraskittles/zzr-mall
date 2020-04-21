package com.zzr.mall.dao;


import com.zzr.mall.model.PropertyValue;

import java.util.List;

public interface PropertyValueDao {


    List<PropertyValue> selectByProductId(int productId);
}