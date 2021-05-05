package com.araujojpc.wms.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@PostMapping
	private ResponseEntity<Item> insert(@RequestBody Item obj) {
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
