package com.medmota.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medmota.banque.models.Client;

public interface IClientRepository extends JpaRepository<Client, Long>{

}
