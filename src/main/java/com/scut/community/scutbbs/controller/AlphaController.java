package com.scut.community.scutbbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author wuyuda
 * @date 2022-11-08 19:44
 */
@RestController
@RequestMapping("/alpha")
public class AlphaController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello!!!!!";
    }
}
