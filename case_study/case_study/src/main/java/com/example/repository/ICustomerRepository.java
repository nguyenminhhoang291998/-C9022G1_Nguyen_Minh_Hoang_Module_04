package com.example.repository;

import com.example.model.Customer;
import com.example.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select * from customer where name like :name and email like :email and customer_type_id = :id and flag = true",nativeQuery = true)
    Page<Customer> findByNameAndEmailAndCustomerTypeId (@Param("name") String name,@Param("email") String email,@Param("id") int customerTypeId, Pageable pageable);

    @Query(value = "select * from customer where name like :name and email like :email and flag = true",nativeQuery = true)
    Page<Customer> findByNameAndEmail (@Param("name") String name,@Param("email") String email, Pageable pageable);
}
