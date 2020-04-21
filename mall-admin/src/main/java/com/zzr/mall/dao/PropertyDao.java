package com.zzr.mall.dao;


import com.zzr.mall.model.Property;

import java.util.List;

public interface PropertyDao {


    List<Property> selectByCategoryId(int categoryId);

}