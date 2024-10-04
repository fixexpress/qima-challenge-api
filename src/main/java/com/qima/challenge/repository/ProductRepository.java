package com.qima.challenge.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qima.challenge.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> { }
