package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class CustomerController {

    @RequestMapping("login")
    public String signin(Principal principal, RedirectAttributes ra) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return principal == null ? "users/login" : "redirect:/";
    }


}
