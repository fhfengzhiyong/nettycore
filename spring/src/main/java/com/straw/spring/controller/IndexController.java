package com.straw.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author fengzy
 * @date 2/26/2018
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "hello";
    }
}
