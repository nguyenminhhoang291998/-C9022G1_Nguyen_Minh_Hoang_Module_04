package com.example.repository;

import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where name like :name and email like :email and customer_type_id = :id and flag = true", nativeQuery = true)
    Page<Customer> findByNameAndEmailAndCustomerTypeId(@Param("name") String name, @Param("email") String email, @Param("id") int customerTypeId, Pageable pageable);

    @Query(value = "select * from customer where name like :name and email like :email and flag = true", nativeQuery = true)
    Page<Customer> findByNameAndEmail(@Param("name") String name, @Param("email") String email, Pageable pageable);

    @Query(value = "select * from customer where flag = true", nativeQuery = true)
    List<Customer> findAll();

    @Query(value = "select * from customer where (email = :email or phone_number = :phoneNumber or id_card = :idCard)  and flag = true limit 1", nativeQuery = true)
    Customer checkExistsSave(@Param("email") String email, @Param("phoneNumber") String phoneNumber, @Param("idCard") String idCard);

    @Query(value = "select * from customer where (email = :email or phone_number = :phoneNumber or id_card = :idCard) and flag = true and id <> :id limit 1", nativeQuery = true)
    Customer checkExistsUpdate(@Param("id") int id, @Param("email") String email, @Param("phoneNumber") String phoneNumber, @Param("idCard") String idCard);
//    Customer findByEmail(String email);
//    Customer findByPhoneNumber(String phoneNumber);
//    Customer findByIdCard(String idCard);
}
