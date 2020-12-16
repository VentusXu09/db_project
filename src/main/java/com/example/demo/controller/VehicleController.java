package com.example.demo.controller;

import com.example.demo.domain.OfficeLocation;
import com.example.demo.domain.Vehicle;
import com.example.demo.domain.VehicleClass;
import com.example.demo.domain.support.State;
import com.example.demo.repository.OfficeLocationRepository;
import com.example.demo.repository.VehicleClassRepository;
import com.example.demo.repository.VehicleRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleClassRepository vehicleClassRepository;

    @Autowired
    private OfficeLocationRepository officeLocationRepository;

    @GetMapping("/models")
    public String getVehicleModels() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();

        OfficeLocation office = officeLocationRepository.getOne((long) 100000);
        VehicleClass type = vehicleClassRepository.getOne((long) 100001);
        List<Vehicle> ress = vehicleRepository.findByOfficeLocationAndVehicleClass(office, type);


        HashMap<Long, String> types = new HashMap<>();

        for (Vehicle v: vehicleList
             ) {
            VehicleClass vehicleClass = v.getVehicleClass();
            types.put(vehicleClass.getId(), vehicleClass.getType());
        }
        String n = State.NEW_YORK.getAbbreviation();

        String res = new Gson().toJson(types);

        return res;
    }

}
