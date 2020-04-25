package com.zzr.mall.service;


import com.zzr.mall.model.User;

import java.util.List;

public interface UserService {
    User selectUser(int id);
    List<User> selectUsers(int pageNum,int pageSize);
}
