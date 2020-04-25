package com.zzr.mall.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzr.mall.dao.UserDao;
import com.zzr.mall.mapper.UserMapper;
import com.zzr.mall.model.User;
import com.zzr.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserDao userDao;
    @Override
    public User selectUser(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        user.setPassword(null);
        return user;
    }

    @Override
    public List<User> selectUsers(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userDao.selectUsers();
        return users;
    }
}
