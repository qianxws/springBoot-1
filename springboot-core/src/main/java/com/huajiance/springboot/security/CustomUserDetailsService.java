package com.huajiance.springboot.security;

import com.huajiance.springboot.entity.TUser;
import com.huajiance.springboot.service.UserService;
import com.huajiance.springboot.utils.RedisUtils;
import com.huajiance.springboot.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 自定义userDetailsService
 *
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库中取出用户信息
        TUser user = userService.getByUserId(username);
        if(user != null){
            String token = UUID.randomUUID().toString().replaceAll("-","");
//            TokenUtils.tokenMap.put(user.getUserId(), token);
            redisUtils.set(user.getUserId(), token);
        }

        // 判断用户是否存在
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        // 返回UserDetails实现类
        User userDetails = new User(user.getName(), user.getPassword(),  AuthorityUtils.commaSeparatedStringToAuthorityList("root"));
        return userDetails;
    }
}