package com.provavis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.provavis.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
