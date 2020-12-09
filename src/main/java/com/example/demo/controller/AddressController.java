package com.example.demo.controller;

import com.example.demo.domain.Address;
import com.example.demo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/addresses")
    public List<Address> getAllAdresses() {
        return addressRepository.findAll();
    }

    @GetMapping("/addresses/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable(value = "id") Long addressId) throws Exception {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new Exception("Adress" + addressId + "not Found"));

        return ResponseEntity.ok().body(address);
    }

    @PostMapping("/addresses")
    public Address createAddress(@Valid @RequestBody Address address) {
        return addressRepository.save(address);
    }

    @PutMapping("/addresses/{id}")
    public ResponseEntity<Address> updateAddress(
            @PathVariable(value = "id") Long addressId, @Valid @RequestBody Address addressDetails
    ) throws Exception {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new Exception("Adress" + addressId + "not Found"));

        address.setCity(addressDetails.getCity());
        address.setCountry(addressDetails.getCountry());
        address.setState(addressDetails.getState());
        address.setStreet(addressDetails.getStreet());
        address.setZipcode(addressDetails.getZipcode());

        final Address updatedAddress = addressRepository.save(address);

        return ResponseEntity.ok(updatedAddress);
    }

    @DeleteMapping("/address/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") Long addressId) throws Exception {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new Exception("Adress" + addressId + "not Found"));

        addressRepository.delete(address);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
