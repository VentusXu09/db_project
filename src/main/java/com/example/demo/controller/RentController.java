package com.example.demo.controller;

import com.example.demo.domain.Invoice;
import com.example.demo.domain.VehicleClass;
import com.example.demo.domain.dto.UserDto;
import com.example.demo.utils.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Locale;

@Controller
public class RentController {
    @RequestMapping("search")
    public String signup(final HttpServletRequest request, Model model) {
        Locale locale = request.getLocale();
        model.addAttribute("lang", locale.getLanguage());
        return "rent/search";
    }

    @GetMapping("invoice/{id}")
    public String invoice(final HttpServletRequest request, Model model, @PathVariable String id) {
        Locale locale = request.getLocale();
        model.addAttribute("lang", locale.getLanguage());
        return "rent/invoice";
    }

    @RequestMapping("choose")
    public String choose(final HttpServletRequest request, Model model) {
        Locale locale = request.getLocale();
        model.addAttribute("lang", locale.getLanguage());
        return "users/choose";
    }

    @RequestMapping("payment")
    public String payment(final HttpServletRequest request, Model model) {
        Locale locale = request.getLocale();
        model.addAttribute("lang", locale.getLanguage());
        return "rent/payment";
    }

    @RequestMapping("rent")
    public String invoice(final HttpServletRequest request, Model model) {
        Locale locale = request.getLocale();
        model.addAttribute("lang", locale.getLanguage());
        return "rent/invoice";
    }





}
