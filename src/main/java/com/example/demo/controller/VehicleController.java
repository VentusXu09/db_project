package com.example.demo.controller;

import com.example.demo.domain.OfficeLocation;
import com.example.demo.domain.Vehicle;
import com.example.demo.domain.VehicleClass;
import com.example.demo.domain.dto.VehicleDto;
import com.example.demo.domain.support.State;
import com.example.demo.repository.OfficeLocationRepository;
import com.example.demo.repository.VehicleClassRepository;
import com.example.demo.repository.VehicleRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.demo.utils.Utils.isStringEmpty;

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

    @PostMapping("/models")
    public String getVehicleModelByIds(@Valid VehicleDto vehicleDto) {
        OfficeLocation office = officeLocationRepository.getOne(Long.valueOf(vehicleDto.getOffice_id()));
        VehicleClass type = vehicleClassRepository.getOne(Long.valueOf(vehicleDto.getVehicle_id()));
        List<Vehicle> res = vehicleRepository.findByOfficeLocationAndVehicleClass(office, type);

        Map<String, Map<String, String>> models = new HashMap<>();
        for (Vehicle v: res
             ) {
            VehicleClass vehicleClass = v.getVehicleClass();

            Map<String, String> model = new HashMap<>();
            model.put("model", v.getModel());
            model.put("make", v.getMake());
            model.put("year", v.getYear());
            model.put("type",vehicleClass.getType());

            models.put(String.valueOf(v.getId()), model);

        }

        String json = new Gson().toJson(models);

        return isStringEmpty(json) ? "": json;
    }
}
