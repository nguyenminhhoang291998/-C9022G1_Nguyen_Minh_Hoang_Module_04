package com.example.service;

import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    Page<Customer> search(String name,String email, int customerType, Pageable pageable);

    boolean save(Customer customer);
    boolean update(Customer customer);
    void delete(Customer customer);


    Customer findById(int id);

    List<Customer> findAll();

}
