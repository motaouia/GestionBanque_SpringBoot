package com.mota.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mota.banque.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}
