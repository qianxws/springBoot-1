package com.huajiance.springboot.web;

import com.alibaba.fastjson.JSONObject;
import com.huajiance.springboot.service.UserService;
import com.huajiance.springboot.utils.RedisUtils;
import com.huajiance.springboot.utils.TokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtils redisUtils;

    public String showHome() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info("当前登陆用户：" + name);

        return "home.html";

    }

    public JSONObject showLogin(String token) {
        JSONObject json = new JSONObject();
        // 获取当前登录用户
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String realtoken=redisUtils.get(username) != null ? redisUtils.get(username) : "";

        if ("anonymousUser".equals(username)){
            json.put("success",false);
            json.put("data", null);
            json.put("errorCode", "10086"); // 10086：未登录
        }else if(realtoken.equals(token)){
            List<String> menus = userService.getMenusByUserId("zhengshi");
            Map<String, Object> returnMap = new HashMap<>();
            returnMap.put("token", TokenUtils.tokenMap.get("username"));
            returnMap.put("menus", menus);

            json.put("success",true);
            json.put("data", returnMap);
            json.put("errorCode", ""); // 登录成功
        }else{
            json.put("success",false);
            json.put("data", null);
            json.put("errorCode", "404"); // 404: 未知错误
        }

        return json;
    }

}