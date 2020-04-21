package com.zzr.mall.service;


import com.zzr.mall.model.Property;

import java.util.List;

public interface PropertyService {
   int insert(Property property);
   int delete(int propertyId);
   int update(Property property);
   List<Property> selectByPage(int CategoryId, int pageSize, int pageNum);
}
