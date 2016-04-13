package com.htest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Tomasz on 13.04.2016.
 */
@Controller
public class Home {

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }
}
