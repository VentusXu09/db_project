package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Locale;

@Controller
public class CustomerController {

    @RequestMapping("login")
    public String signin(Principal principal, RedirectAttributes ra) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return principal == null ? "users/login" : "redirect:search";
    }

    @RequestMapping("signup")
    public String signup(final HttpServletRequest request, Model model) {
        Locale locale = request.getLocale();
        model.addAttribute("lang", locale.getLanguage());
        return "users/signup";
    }


}
