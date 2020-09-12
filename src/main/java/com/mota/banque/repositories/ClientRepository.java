package com.mota.banque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mota.banque.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
