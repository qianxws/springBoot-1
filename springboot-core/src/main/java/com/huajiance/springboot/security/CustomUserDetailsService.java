package com.huajiance.springboot.security;

import com.huajiance.springboot.entity.TUser;
import com.huajiance.springboot.entity.TUserRole;
import com.huajiance.springboot.service.RoleService;
import com.huajiance.springboot.service.UserService;
import com.huajiance.springboot.utils.RedisUtils;
import com.huajiance.springboot.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 自定义userDetailsService
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库中取出用户信息
        TUser user = userService.getByUserId(username);

        List<TUserRole> roleList = null;
        // 判断用户是否存在
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        } else {
            // 查询用户角色(对象封装)
            roleList = roleService.getRoleByUserId(username);
        }
        List<String> roles = new ArrayList<String>();
        for (TUserRole tUserRole : roleList) {
            roles.add(tUserRole.getRoleId());
        }
        String[] strings = new String[roles.size()];
        strings = roles.toArray(strings);

        // 返回UserDetails实现类
        User userDetails = new User(user.getName(), user.getPassword(), AuthorityUtils.createAuthorityList(strings));
        return userDetails;
    }
}