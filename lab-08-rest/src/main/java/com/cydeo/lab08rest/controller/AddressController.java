package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.AddressService;
import com.cydeo.lab08rest.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;
    private final CustomerService customerService;

    public AddressController(AddressService addressService, CustomerService customerService) {
        this.addressService = addressService;
        this.customerService = customerService;
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

        return ResponseEntity
                .ok(new ResponseWrapper(
                        "Address updated successfully",
                        addressService.updateAddress(address)
                        , HttpStatus.OK));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<ResponseWrapper> getAddressListByCustomerId(@PathVariable("id") Long id) {
        return ResponseEntity
                .ok(new ResponseWrapper("Addresses by Id", addressService.getAddressesById(id), HttpStatus.OK));
    }

    @GetMapping("/startsWith/{address}")
    public ResponseEntity<ResponseWrapper> getAddressListByStartsWithAddress(@PathVariable("address") String address) {

        return ResponseEntity
                .ok(new ResponseWrapper("Addresses starts with",
                        addressService.getAddressByStartsWith(address), HttpStatus.OK));
    }

    @GetMapping("/customer/{customerId}/name/{name}")
    public ResponseEntity<ResponseWrapper> getAddressListByCustomerAndName(@PathVariable("customerId") Long customerId, @PathVariable String name) {

        return ResponseEntity
                .ok(new ResponseWrapper("Address List by Customer and Name",
                        addressService.getAddressesByCustomerAndName(customerService.findById(customerId).getId(), name)
                        , HttpStatus.OK));

    }


}
