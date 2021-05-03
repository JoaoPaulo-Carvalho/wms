package com.araujojpc.wms.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.araujojpc.wms.entities.Item;
import com.araujojpc.wms.services.ItemService;

@RestController
@RequestMapping(value = "/items")
public class ItemResource {

	@Autowired
	private ItemService service;

	@GetMapping
	private ResponseEntity<List<Item>> findAll() {
		List<Item> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	private ResponseEntity<Item> findById(@PathVariable Long id) {
		Item obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
