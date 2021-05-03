package com.araujojpc.wms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.araujojpc.wms.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
