package com.htest.controller;

import com.htest.model.AppUser;
import com.htest.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Tomasz on 13.04.2016.
 */
@Controller
public class Home {

    @Autowired
    AppUserService appUserService;

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/init")
    public String addUser() {
        appUserService.insertUser(new AppUser(1, "Ala", "password"));
        appUserService.insertUser(new AppUser(2, "Ola", "password"));
        appUserService.insertUser(new AppUser(3, "Kasia", "password"));
        appUserService.insertUser(new AppUser(4, "Basia", "password"));
        appUserService.insertUser(new AppUser(5, "Joasia", "password"));
        return "home";
    }

    @RequestMapping(value = "/get")
    public String getUser() {
        appUserService.getUser(1);
        return "home";
    }
}
