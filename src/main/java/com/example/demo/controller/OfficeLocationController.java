package com.example.demo.controller;

import com.example.demo.domain.Corporation;
import com.example.demo.domain.OfficeLocation;
import com.example.demo.repository.CorporationRepository;
import com.example.demo.repository.OfficeLocationRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController
//public class OfficeLocationController {
//
//    @Autowired
//    private OfficeLocationRepository officeLocationRepository;
//
//    @GetMapping(value = "/api/officeLocation")
//    public String getOfficeLocation() {
//        List<OfficeLocation> res = officeLocationRepository.findAll();
//        Type type = new TypeToken<List<OfficeLocation>>(){}.getType();
//
//
//    }
//}
