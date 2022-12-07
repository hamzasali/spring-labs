package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.AddressDTO;

import java.util.List;

public interface AddressService {
    List<AddressDTO> getAddresses();
    AddressDTO createAddress(AddressDTO address);
    AddressDTO updateAddress(AddressDTO address);

    List<AddressDTO> getAddressesById(Long id);

}
