package com.zzr.mall.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.zzr.mall.dao.PropertyDao;
import com.zzr.mall.dto.PropertyAddParam;
import com.zzr.mall.dto.PropertyUpdateParam;
import com.zzr.mall.mapper.PropertyMapper;
import com.zzr.mall.model.Property;
import com.zzr.mall.service.PropertyService;
import org.springframework.beans.BeanUtils;
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
    public int insert(PropertyAddParam param) {
        Property property = new Property();
        property.setCid(param.getCid());
        property.setName(param.getName());
        int i = 0;
            i= propertyMapper.insertSelective(property);
        return i;
    }

    @Override
    public int delete(int propertyId) {
        int i = propertyMapper.deleteByPrimaryKey(propertyId);
        return i;
    }

    @Override
    public int update(PropertyUpdateParam param) {
        Property property = new Property();
        BeanUtils.copyProperties(param,property);
        int i = propertyMapper.updateByPrimaryKeySelective(property);
        return i;
    }

    @Override
    public List<Property> selectProperty(int categoryId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Property> properties = propertyDao.selectByCategoryId(categoryId);
        return properties;
    }

    @Override
    public Property selectOne(int propertyId) {
        Property property = propertyMapper.selectByPrimaryKey(propertyId);
        return property;
    }
}
