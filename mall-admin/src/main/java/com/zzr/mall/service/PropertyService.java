package com.zzr.mall.service;


import com.zzr.mall.dto.PropertyAddParam;
import com.zzr.mall.dto.PropertyUpdateParam;
import com.zzr.mall.model.Property;

import java.util.List;

public interface PropertyService {
   int insert(PropertyAddParam param);
   int delete(int propertyId);
   int update(PropertyUpdateParam param);
   List<Property> selectProperty(int categoryId, int pageNum, int pageSize);
   Property selectOne(int propertyId);
}
