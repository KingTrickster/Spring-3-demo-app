package com.trxjster.spring3demo.repository;

import com.trxjster.spring3demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
