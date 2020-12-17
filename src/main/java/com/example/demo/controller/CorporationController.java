package com.example.demo.controller;

import com.example.demo.domain.Corporation;
import com.example.demo.repository.CorporationRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CorporationController {
    @Autowired
    private CorporationRepository corporationRepository;

    @GetMapping(value = "/api/corporation_name")
    public String getCorporations() {
        List<Corporation> res = corporationRepository.findAll();
        Type type = new TypeToken<List<Corporation>>(){}.getType();

        Map<String, String> s = new HashMap<>();

        for (Corporation corp: res
             ) {
            s.put(corp.getCorpName(), String.valueOf(corp.getId()));
        }

        String jjson = new Gson().toJson(s);

        return jjson;
    }
}
