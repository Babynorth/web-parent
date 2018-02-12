package com.babynorth.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhengbei
 * @date 2018/2/7.
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("name", "郑北");
        model.addAttribute("age", 28);
        return "test";
    }
}
