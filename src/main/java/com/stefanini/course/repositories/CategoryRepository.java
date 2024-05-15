package com.stefanini.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefanini.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
}
