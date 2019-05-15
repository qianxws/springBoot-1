package com.huajiance.springboot.service;

import com.huajiance.springboot.entity.TMenu;

import java.util.List;

public interface MenuService {

    /**
     * 获取用户菜单
     * */
    List<String> getUserMenus();

    List<TMenu> getUserMenusByRoleId(String roleId);
}
