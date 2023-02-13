package com.example.repository;

import com.example.model.Contract;
import com.example.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
}
