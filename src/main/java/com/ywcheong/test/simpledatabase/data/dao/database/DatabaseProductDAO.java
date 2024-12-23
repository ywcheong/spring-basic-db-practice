package com.ywcheong.test.simpledatabase.data.dao.database;

import com.ywcheong.test.simpledatabase.data.dao.model.ProductDAO;
import com.ywcheong.test.simpledatabase.data.entity.Product;
import com.ywcheong.test.simpledatabase.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class DatabaseProductDAO implements ProductDAO {
    private final ProductRepository productRepository;

    @Autowired
    public DatabaseProductDAO(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product selectProductById(Long id) {
        Optional<Product> selectedProduct = productRepository.findById(id);
        return selectedProduct.orElse(null);
    }

    @Override
    public Product updateProductName(Long id, String name) throws Exception {
        Optional<Product> foundProduct = productRepository.findById(id);
        if(foundProduct.isEmpty()) {
            throw new Exception(String.format("Product id %d not found", id));
        }

        Product editingProduct = foundProduct.get();
        editingProduct.setName(name);
        editingProduct.setUpdatedAt(LocalDateTime.now());

        return productRepository.save(editingProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> foundProduct = productRepository.findById(id);
        if(foundProduct.isEmpty()) {
            return;
        }

        Product deletingProduct = foundProduct.get();
        productRepository.delete(deletingProduct);
    }
}
