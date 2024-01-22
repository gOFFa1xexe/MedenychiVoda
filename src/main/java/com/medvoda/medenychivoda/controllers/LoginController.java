package com.medvoda.medenychivoda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/home")
    public String getLoginForm(){
        return "home";
    }
}
