package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    ProductDTO create(ProductDTO product);

    ProductDTO update(ProductDTO product);

    List<ProductDTO> getAll();

    ProductDTO getByName(String name);

    List<ProductDTO> getAllByName(String name);

    List<ProductDTO> getAllByCategory(String name);

    List<ProductDTO> getAllByPrice(BigDecimal price);

    List<ProductDTO> getAllByPriceAndQuantity(BigDecimal price, Integer quantity);


}
