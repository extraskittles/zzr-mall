package com.zzr.mall.service.serviceImpl;

import com.zzr.mall.mapper.UserMapper;
import com.zzr.mall.model.User;
import com.zzr.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User selectUser(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
