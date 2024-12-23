package com.ywcheong.test.simpledatabase.data.dao.model;

import com.ywcheong.test.simpledatabase.data.entity.Product;

public interface ProductDAO {
    Product insertProduct(Product product);
    Product selectProductById(Long id);
    Product updateProductName(Long id, String name) throws Exception;
    void deleteProduct(Long id);
}
