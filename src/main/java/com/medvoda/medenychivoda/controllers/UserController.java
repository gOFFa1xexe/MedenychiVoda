package com.medvoda.medenychivoda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/singin")
    public String singIn() {
        return "FormLogin.html";
    }

}
