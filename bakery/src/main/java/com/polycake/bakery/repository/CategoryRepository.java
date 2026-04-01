package com.polycake.bakery.repository;

import com.polycake.bakery.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Để trống, Spring Boot tự lo việc SELECT * FROM Categories
}