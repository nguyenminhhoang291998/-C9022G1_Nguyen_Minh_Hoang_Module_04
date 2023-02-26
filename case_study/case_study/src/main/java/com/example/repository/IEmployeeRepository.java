package com.example.repository;

import com.example.model.Customer;
import com.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByUser_Username(String username);

    Page<Employee> findAll(Pageable pageable);
}
