package com.huajiance.springboot.web.common;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 跳转页面
 */
@Controller
@RequestMapping("/viewsController")
public class ViewsController extends BaseController {

    @RequestMapping("/user")
    public ModelAndView User(HttpServletRequest request, HttpServletResponse resp){
        return new ModelAndView("user/index");
    }
}
