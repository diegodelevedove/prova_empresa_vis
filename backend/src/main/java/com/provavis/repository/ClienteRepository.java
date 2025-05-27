package com.provavis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.provavis.entities.Conta;

@Repository
public interface ClienteRepository extends JpaRepository<Conta, Long>  {
	
}
