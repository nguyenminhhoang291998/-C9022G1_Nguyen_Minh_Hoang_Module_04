package com.example.service.impl;

import com.example.model.CustomerType;
import com.example.repository.ICustomerRepository;
import com.example.repository.ICustomerTypeRepository;
import com.example.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(int id) {
        return customerTypeRepository.findById(id).orElse(new CustomerType());
    }
}
