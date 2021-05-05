package com.araujojpc.wms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.araujojpc.wms.entities.Item;
import com.araujojpc.wms.repositories.ItemRepository;
import com.araujojpc.wms.services.exceptions.ResourceNotFoundException;

@Service
public class ItemService {

	@Autowired
	private ItemRepository repository;

	public List<Item> findAll() {
		return repository.findAll();
	}
	
	public Item findById(Long id) {
		Optional<Item> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public void insert(Item obj) {
		repository.save(obj);		
	}
	
	public void delete(Long id) {	
		repository.deleteById(id);
	}
}
