package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.dto.CustomerDTO;

import java.util.List;

public interface AddressService {
    List<AddressDTO> getAddresses();

    AddressDTO createAddress(AddressDTO address);

    AddressDTO updateAddress(AddressDTO address);

    List<AddressDTO> getAddressesById(Long id);

    List<AddressDTO> getAddressByStartsWith(String street);

    List<AddressDTO> getAddressesByCustomerAndName(Long customerId, String AddressName);
}
