package com.medmota.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medmota.banque.models.Compte;

public interface ICompteRepository extends JpaRepository<Compte, String>{

}
