package com.araujojpc.wms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.araujojpc.wms.entities.Movement;
import com.araujojpc.wms.repositories.MovementRepository;

@Service
public class MovementService {

	@Autowired
	private MovementRepository repository;

	public List<Movement> findAll() {
		return repository.findAll();
	}
}
