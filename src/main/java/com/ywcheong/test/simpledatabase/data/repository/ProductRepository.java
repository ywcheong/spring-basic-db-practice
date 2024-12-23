package com.ywcheong.test.simpledatabase.data.repository;

import com.ywcheong.test.simpledatabase.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}