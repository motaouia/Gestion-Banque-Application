package com.medmota.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medmota.banque.models.Groupe;

public interface IGroupeRepository  extends JpaRepository<Groupe, Long>{

}
