package com.huajiance.springboot.web;

import com.alibaba.fastjson.JSONObject;
import com.huajiance.springboot.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

    @RequestMapping("/getUserMenus")
    @ResponseBody
    public JSONObject getUserMenus() {
        JSONObject json = new JSONObject();
        List<String> menulist = menuService.getUserMenus();
        json.put("menuList", menulist);
        logger.info("------------获取所有菜单---------------");
        return json;
    }
}