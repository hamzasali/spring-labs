package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.entity.Discount;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.DiscountRepository;
import com.cydeo.lab08rest.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepository discountRepository;
    private final MapperUtil mapperUtil;

    public DiscountServiceImpl(DiscountRepository discountRepository, MapperUtil mapperUtil) {
        this.discountRepository = discountRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<DiscountDTO> findAll() {
        List<Discount> list = discountRepository.findAll();
        return list.stream()
                .map(discount -> mapperUtil.convert(discount, new DiscountDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<DiscountDTO> findAllByName(String name) {
        Discount byName = discountRepository.findFirstByName(name);
        return null;
    }

    @Override
    public DiscountDTO findByName(String name) {
        return mapperUtil.convert(discountRepository.findFirstByName(name), new DiscountDTO());
    }

    @Override
    public DiscountDTO create(DiscountDTO discount) {
        Discount discount1 = discountRepository.save(mapperUtil.convert(discount, new Discount()));
        return mapperUtil.convert(discount1, new DiscountDTO());
    }

    @Override
    public DiscountDTO update(DiscountDTO discount) {
        Discount discountFromDB = discountRepository.findById(discount.getId()).get();
        Discount converted = mapperUtil.convert(discountFromDB, new Discount());
        converted.setId(discountFromDB.getId());
        discountRepository.save(converted);
        return discount;
    }
}
