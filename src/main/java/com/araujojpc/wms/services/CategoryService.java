package com.araujojpc.wms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.araujojpc.wms.entities.Category;
import com.araujojpc.wms.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;

	public List<Category> findAll() {		
		return repository.findAll();
	}
}
