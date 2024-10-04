package com.qima.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qima.challenge.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> { }
