package com.provavis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.provavis.entities.SalesPerson;

@Repository
public interface SalesPersonRepository extends JpaRepository<SalesPerson, Long> {

}
