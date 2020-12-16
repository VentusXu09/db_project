package com.example.demo.repository;

import com.example.demo.domain.OfficeLocation;
import com.example.demo.domain.Vehicle;
import com.example.demo.domain.VehicleClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByOfficeLocationAndVehicleClass(OfficeLocation officeLocation, VehicleClass vehicleClass);
}
