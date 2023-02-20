package com.example.repository;

import com.example.dto.IContractDto;
import com.example.model.Contract;
import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    Page<Contract> findAll(Pageable pageable);

    @Query(value = "select * from select_all_contract_dto",nativeQuery = true)
    Page<IContractDto> showListContract(Pageable pageable);

}
