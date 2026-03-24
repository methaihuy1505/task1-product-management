package com.example.product_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product_management.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
