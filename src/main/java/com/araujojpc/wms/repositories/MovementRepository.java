package com.araujojpc.wms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.araujojpc.wms.entities.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long> {

}
