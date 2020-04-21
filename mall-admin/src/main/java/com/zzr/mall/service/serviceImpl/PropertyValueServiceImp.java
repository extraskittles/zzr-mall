package com.zzr.mall.service.serviceImpl;


import com.zzr.mall.dao.PropertyValueDao;
import com.zzr.mall.mapper.PropertyValueMapper;
import com.zzr.mall.model.PropertyValue;
import com.zzr.mall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyValueServiceImp implements PropertyValueService {
@Autowired
PropertyValueMapper propertyValueMapper;
@Autowired
    PropertyValueDao propertyValueDao;
    @Override
    public List<PropertyValue> selectByProductId(int productId) {
        List<PropertyValue> propertyValues = propertyValueDao.selectByProductId(productId);
        return propertyValues;
    }

    @Override
    public int delete(int id) {
        int i = propertyValueMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int insert(PropertyValue propertyValue) {
        int i = propertyValueMapper.insertSelective(propertyValue);
        return i;
    }

    @Override
    public int update(PropertyValue propertyValue) {
        int i = propertyValueMapper.updateByPrimaryKeySelective(propertyValue);
        return i;
    }
}
