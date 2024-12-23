package com.ywcheong.test.simpledatabase.service.model;

import com.ywcheong.test.simpledatabase.data.dto.ProductRequestDTO;
import com.ywcheong.test.simpledatabase.data.dto.ProductResponseDTO;

public interface ProductService {
    ProductResponseDTO getProduct(Long id);
    ProductResponseDTO saveProduct(ProductRequestDTO productDto);
    ProductResponseDTO changeProductName(Long id, String name) throws Exception;
    void deleteProduct(Long number);
}
