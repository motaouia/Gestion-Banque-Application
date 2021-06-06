package com.medmota.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medmota.banque.models.Operation;

public interface IOperationRepository extends JpaRepository<Operation, Long> {

}
