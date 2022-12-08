package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.entity.Order;
import com.cydeo.lab08rest.enums.PaymentMethod;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.CartRepository;
import com.cydeo.lab08rest.repository.OrderRepository;
import com.cydeo.lab08rest.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final MapperUtil mapperUtil;
    private final CartRepository cartRepository;

    public OrderServiceImpl(OrderRepository orderRepository, MapperUtil mapperUtil, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.mapperUtil = mapperUtil;
        this.cartRepository = cartRepository;
    }

    @Override
    public List<OrderDTO> getAll() {
        List<Order> orderList = orderRepository.findAll();
        return orderList.stream().map(order -> mapperUtil.convert(order, new OrderDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getAllByEmail(String email) {
        List<Order> allByCustomerEmail = orderRepository.findAllByCustomer_Email(email);
        return allByCustomerEmail.stream().map(order -> mapperUtil.convert(order, new OrderDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getAllByPaymentMethod(PaymentMethod paymentMethod) {
        List<Order> allByPaymentPaymentMethod = orderRepository.findAllByPayment_PaymentMethod(paymentMethod);
        return allByPaymentPaymentMethod.stream().map(order -> mapperUtil.convert(order, new OrderDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO create(OrderDTO order) {
        Order orderFromDB = orderRepository.save(mapperUtil.convert(order, new Order()));
        return mapperUtil.convert(orderFromDB, new OrderDTO());
    }

    @Override
    public OrderDTO update(OrderDTO order) {
        Order converted = mapperUtil.convert(order, new Order());
        orderRepository.save(converted);
        return order;
    }
}
