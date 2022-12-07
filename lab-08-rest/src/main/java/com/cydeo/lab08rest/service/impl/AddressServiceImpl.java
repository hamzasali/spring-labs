package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.AddressRepository;
import com.cydeo.lab08rest.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;

    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<AddressDTO> getAddresses() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream().map(address -> mapperUtil.convert(address, new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public AddressDTO createAddress(AddressDTO address) {
        addressRepository.save(mapperUtil.convert(address, new Address()));
        return address;
    }

    @Override
    public AddressDTO updateAddress(AddressDTO address) {
        Address address1 = addressRepository.findByStreet(address.getStreet());
        Address convertedAddress = mapperUtil.convert(address, new Address());
        convertedAddress.setId(address1.getId());
        addressRepository.save(convertedAddress);
        return address;
    }

    @Override
    public List<AddressDTO> getAddressesById(Long id) {
        List<Address> addresses = addressRepository.retrieveByCustomerId(id);
        return addresses.stream()
                .map(address -> mapperUtil.convert(address, new AddressDTO()))
                .collect(Collectors.toList());
    }
}
