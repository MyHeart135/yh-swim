package com.yh.swim.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台管理类
 *
 * @author yanhuan1
 */
@Controller
public class CenterController {

    @RequestMapping("hello")
    public String hello(Model model) {
        model.addAttribute("yh", "yh");
        return "index";
    }
}
