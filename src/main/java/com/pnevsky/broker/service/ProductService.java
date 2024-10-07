package com.pnevsky.broker.service;

import com.pnevsky.broker.service.dto.CreateProductDTO;

public interface ProductService {

    String createProduct(CreateProductDTO createProductDTO);
}
