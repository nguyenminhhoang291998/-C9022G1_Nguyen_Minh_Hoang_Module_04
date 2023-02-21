package com.example.repository;

import com.example.dto.IContractDetailDto;
import com.example.dto.IContractDto;
import com.example.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    Page<Contract> findAll(Pageable pageable);

    @Query(value = "select * from select_all_contract_dto",nativeQuery = true)
    Page<IContractDto> showListContract(Pageable pageable);

    @Query(value = "select * from select_contract_detail where contract_id = :id",nativeQuery = true)
    List<IContractDetailDto> findContractDetailByContractId(@Param("id") int id);

}
