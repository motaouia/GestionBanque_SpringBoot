package com.mota.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mota.banque.entities.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {

}
