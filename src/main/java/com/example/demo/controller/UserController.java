package com.example.demo.controller;

import com.example.demo.domain.dto.UserDto;
import com.example.demo.utils.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@Slf4j
public class UserController {

    @PostMapping("/user/registration")
    public GenericResponse registerUserAccount(@Valid final UserDto accountDto, final HttpServletRequest request) {
        log.debug("Registering user account with information: {}", accountDto);

        return new GenericResponse("success");
    }
}
