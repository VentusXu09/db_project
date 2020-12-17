package com.example.demo.controller;

import com.example.demo.domain.OfficeLocation;
import com.example.demo.repository.OfficeLocationRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OfficeLocationController {

    @Autowired
    private OfficeLocationRepository officeLocationRepository;

    @GetMapping(value = "/api/officeLocation")
    public String getOfficeLocation() {
        List<OfficeLocation> locations = officeLocationRepository.findAll();

        Map<String, String> list = new HashMap();
        for (OfficeLocation office: locations
             ) {
            list.put(String.valueOf(office.getId()), office.toString());
        }

        String json = new Gson().toJson(list);

        return json;
    }
}
