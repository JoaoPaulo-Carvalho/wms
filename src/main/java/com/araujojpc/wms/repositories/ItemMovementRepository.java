package com.araujojpc.wms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.araujojpc.wms.entities.ItemMovement;

public interface ItemMovementRepository extends JpaRepository<ItemMovement, Long> {

}
