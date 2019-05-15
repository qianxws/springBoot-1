package com.huajiance.springboot.mapper;

import com.huajiance.springboot.entity.TMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    List<String> getUserMenus();

    List<TMenu> getUserMenusByRoleId(@Param("roleId") String roleId);
}
