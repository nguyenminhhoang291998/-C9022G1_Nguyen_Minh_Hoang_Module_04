package com.example.service;

import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    Page<Customer> search(String name,String email, int customerType, Pageable pageable);

    void save(Customer customer);

//    void delete(int id);

    Customer findById(int id);

    List<Customer> findAll();

}
