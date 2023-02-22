package com.example.service.impl;

import com.example.model.Customer;
import com.example.repository.ICustomerRepository;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> search(String name, String email, int customerTypeId, Pageable pageable) {
        if (customerTypeId == 0) {
            return customerRepository.findByNameAndEmail("%" + name + "%", "%" + email + "%", pageable);
        }
        return customerRepository.findByNameAndEmailAndCustomerTypeId("%" + name + "%", "%" + email + "%", customerTypeId, pageable);
    }

    @Override
    public boolean save(Customer customer) {
        if (customerRepository.checkExistsSave(customer.getEmail(),
                customer.getPhoneNumber(), customer.getIdCard()) != null) {
            return false;
        }
        customer.setFlag(true);
        customerRepository.save(customer);
        return true;
    }

    @Override
    public boolean update(Customer customer) {
        if (customerRepository.checkExistsUpdate(customer.getId(),customer.getEmail(),
                customer.getPhoneNumber(), customer.getIdCard()) != null) {
            return false;
        }
        customer.setFlag(true);
        customerRepository.save(customer);
        return true;
    }

    @Override
    public void delete(Customer customer) {
        customer.setFlag(false);
        customerRepository.save(customer);
    }


    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
