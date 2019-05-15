package com.huajiance.springboot.service.impl;

import com.huajiance.springboot.entity.TMenu;
import com.huajiance.springboot.mapper.MenuMapper;
import com.huajiance.springboot.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuDao;

    @Override
    public List<String> getUserMenus() {
        return menuDao.getUserMenus();
    }

    @Override
    public List<TMenu> getUserMenusByRoleId(String roleId) {
        List<TMenu> roleMap = menuDao.getUserMenusByRoleId(roleId);
        return roleMap;
    }
}
