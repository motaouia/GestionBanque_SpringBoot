package com.mota.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mota.banque.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {

}
