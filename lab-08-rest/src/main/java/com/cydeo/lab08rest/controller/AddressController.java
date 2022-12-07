package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAddressList() {
        return ResponseEntity
                .ok(new ResponseWrapper("Address Retrieved", addressService.getAddresses(), HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createAddress(@RequestBody AddressDTO address) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseWrapper("Address Created", addressService.createAddress(address), HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateAddress(@RequestBody AddressDTO address) {
        addressService.updateAddress(address);
        return ResponseEntity
                .ok(new ResponseWrapper("Address updated successfully", HttpStatus.OK));
    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<ResponseWrapper> getAddressListByCustomerId(@PathVariable("id") Long id) {
        return ResponseEntity
                .ok(new ResponseWrapper("Addresses by Id", addressService.getAddressesById(id),HttpStatus.OK));
    }
//
//    public ResponseEntity<ResponseWrapper> getAddressListByStartsWithAddress(@RequestBody AddressDTO address) {
//    }
//
//    public ResponseEntity<ResponseWrapper> getAddressListByCustomerAndName(@RequestBody AddressDTO address) {
//    }


}
