package com.araujojpc.wms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.araujojpc.wms.entities.Movement;
import com.araujojpc.wms.repositories.ItemMovementRepository;
import com.araujojpc.wms.repositories.MovementRepository;
import com.araujojpc.wms.services.exceptions.ResourceNotFoundException;

@Service
public class MovementService {

	@Autowired
	private MovementRepository repository;
	
	@Autowired
	private ItemMovementRepository itemMovementRepository;

	public List<Movement> findAll() {
		return repository.findAll();
	}

	public Movement findById(Long id) {
		Optional<Movement> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public void insert(Movement obj) {
		repository.save(obj);
		obj.getItems().forEach(i -> i.setMovement(obj));
		itemMovementRepository.saveAll(obj.getItems());
	}

	public void delete(Long id) {
		Movement entity = repository.getOne(id);
		itemMovementRepository.deleteAll(entity.getItems());
		repository.deleteById(id);
	}

	public Movement update(Long id, Movement obj) {
		Movement entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Movement entity, Movement obj) {
		entity.setDescription(obj.getDescription());
		entity.getItems().clear();
		obj.getItems().forEach(item -> {
			entity.getItems().add(item);
			item.setMovement(entity);
		});
		itemMovementRepository.saveAll(obj.getItems());
	}
}
