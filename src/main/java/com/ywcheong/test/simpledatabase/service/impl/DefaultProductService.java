package com.ywcheong.test.simpledatabase.service.impl;

import com.ywcheong.test.simpledatabase.data.dao.database.DatabaseProductDAO;
import com.ywcheong.test.simpledatabase.data.dto.ProductRequestDTO;
import com.ywcheong.test.simpledatabase.data.dto.ProductResponseDTO;
import com.ywcheong.test.simpledatabase.data.entity.Product;
import com.ywcheong.test.simpledatabase.service.model.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultProductService implements ProductService {
    private final DatabaseProductDAO databaseProductDAO;

    @Autowired
    public DefaultProductService(DatabaseProductDAO databaseProductDAO) {
        this.databaseProductDAO = databaseProductDAO;
    }

    @Override
    public ProductResponseDTO getProduct(Long id) {
        Product selectedProduct = databaseProductDAO.selectProductById(id);
        return ProductResponseDTO.builder()
                .id(selectedProduct.getNumber())
                .name(selectedProduct.getName())
                .price(selectedProduct.getPrice())
                .stock(selectedProduct.getStock())
                .build();
    }

    @Override
    public ProductResponseDTO saveProduct(ProductRequestDTO productDto) {
        Product newProduct = new Product();
        newProduct.setName(productDto.getName());
        newProduct.setPrice(productDto.getPrice());
        newProduct.setStock(productDto.getStock());

        Product insertedProduct = databaseProductDAO.insertProduct(newProduct);
        return ProductResponseDTO.builder()
                .id(insertedProduct.getNumber())
                .name(insertedProduct.getName())
                .price(insertedProduct.getPrice())
                .stock(insertedProduct.getStock())
                .build();
    }

    @Override
    public ProductResponseDTO changeProductName(Long id, String name) throws Exception {
        Product updatedProduct = databaseProductDAO.updateProductName(id, name);
        return ProductResponseDTO.builder()
                .id(updatedProduct.getNumber())
                .name(updatedProduct.getName())
                .price(updatedProduct.getPrice())
                .stock(updatedProduct.getStock())
                .build();
    }

    @Override
    public void deleteProduct(Long number) {
        databaseProductDAO.deleteProduct(number);
    }
}
