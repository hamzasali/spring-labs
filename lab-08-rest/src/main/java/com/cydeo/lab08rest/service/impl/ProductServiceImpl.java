package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.entity.Product;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.CategoryRepository;
import com.cydeo.lab08rest.repository.ProductRepository;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final MapperUtil mapperUtil;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, MapperUtil mapperUtil, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.mapperUtil = mapperUtil;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDTO create(ProductDTO product) {
        return mapperUtil.convert(productRepository.save(mapperUtil.convert(product, new Product())), new ProductDTO());
    }

    @Override
    public ProductDTO update(ProductDTO product) {
        Product productFromDB = productRepository.findById(product.getId()).get();
        Product converted = mapperUtil.convert(product, new Product());
        converted.setId(productFromDB.getId());
        productRepository.save(converted);
        return product;
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> productList = productRepository.findAll();

        return productList.stream()
                .map(product -> mapperUtil.convert(product, new ProductDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getByName(String name) {
        Product byName = productRepository.findFirstByName(name);
        return mapperUtil.convert(byName, new ProductDTO());
    }

    @Override
    public List<ProductDTO> getAllByName(String name) {
        return null;
    }

    @Override
    public List<ProductDTO> getAllByCategory(String name) {
        List<Product> productList = productRepository.findAllByCategoryListContaining(categoryRepository.findByName(name));
        return productList.stream()
                .map(product -> mapperUtil.convert(product, new ProductDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getAllByPrice(BigDecimal price) {
        return null;
    }

    @Override
    public List<ProductDTO> getAllByPriceAndQuantity(BigDecimal price, Integer quantity) {
        List<Product> equal = productRepository.findAllByQuantityIsGreaterThanEqual(quantity);

        return null;
    }


}
