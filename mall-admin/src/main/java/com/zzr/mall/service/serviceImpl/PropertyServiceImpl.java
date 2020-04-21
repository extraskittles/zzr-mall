package com.zzr.mall.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.zzr.mall.dao.PropertyDao;
import com.zzr.mall.mapper.PropertyMapper;
import com.zzr.mall.model.Property;
import com.zzr.mall.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyMapper propertyMapper;
    @Autowired
    PropertyDao propertyDao;

    @Override
    public int insert(Property property) {
        int i = propertyMapper.insertSelective(property);
        return i;
    }

    @Override
    public int delete(int propertyId) {
        int i = propertyMapper.deleteByPrimaryKey(propertyId);
        return i;
    }

    @Override
    public int update(Property property) {
        int i = propertyMapper.updateByPrimaryKey(property);
        return i;
    }

    @Override
    public List<Property> selectByPage(int categoryId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Property> properties = propertyDao.selectByCategoryId(categoryId);
        return properties;
    }
}
