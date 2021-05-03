package com.araujojpc.wms.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.araujojpc.wms.entities.Movement;
import com.araujojpc.wms.services.MovementService;

@RestController
@RequestMapping(value = "/movements")
public class MovementResource {

	@Autowired
	private MovementService service;

	@GetMapping
	private ResponseEntity<List<Movement>> findAll() {
		List<Movement> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
