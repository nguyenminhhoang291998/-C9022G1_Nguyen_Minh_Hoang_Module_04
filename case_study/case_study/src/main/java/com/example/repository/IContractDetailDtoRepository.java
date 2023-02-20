package com.example.repository;

import com.example.dto.ContractDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractDetailDtoRepository extends JpaRepository<ContractDetailDto,Integer> {
    @Query(value = "select * from select_contract_detail where contract_id = :id",nativeQuery = true)
    List<ContractDetailDto> findAll(@Param("id") int id);
}
