package com.zzr.mall.dao;


import com.zzr.mall.model.User;

import java.util.List;

public interface UserDao {
    List<User> selectUsers();
}