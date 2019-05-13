package com.huajiance.springboot.service;

import com.huajiance.springboot.entity.TUser;

import java.util.List;

public interface UserService {
    List<String> getMenusByUserId(String username);

    TUser getByUserId(String userId);
}
