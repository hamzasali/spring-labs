package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    ProductDTO create(ProductDTO product);

    ProductDTO update(ProductDTO product);

    List<ProductDTO> getAll();

    List<ProductDTO> getTop3All();

    ProductDTO getByName(String name);

    List<ProductDTO> getAllByCategory(Long id);

    Integer countByPrice(BigDecimal price);

    List<ProductDTO> getAllByPriceAndQuantity(BigDecimal price, Integer quantity);

    List<ProductDTO> retrieveProductByCategoryAndPrice(List<Long> categoryList, BigDecimal price);
}
