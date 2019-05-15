package com.huajiance.springboot.service;

import com.huajiance.springboot.entity.TUser;

import java.util.List;

public interface UserService {

    TUser getByUserId(String userId);
}
