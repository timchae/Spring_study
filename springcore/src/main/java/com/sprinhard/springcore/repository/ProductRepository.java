package com.sprinhard.springcore.repository;

import com.sprinhard.springcore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}