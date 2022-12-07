package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.enums.PaymentMethod;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getAll();

    List<OrderDTO> getAllByEmail(String email);

    List<OrderDTO> getAllByPaymentMethod(PaymentMethod paymentMethod);

    OrderDTO create(OrderDTO order);

    OrderDTO update(OrderDTO order);


}
