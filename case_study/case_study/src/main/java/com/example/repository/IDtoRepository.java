package com.example.repository;

import com.example.model.dto.Dto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IDtoRepository extends JpaRepository<Dto, Integer> {

    @Query(value = "select * from select_all_contract_dto",nativeQuery = true)
    Page<Dto> findAll(Pageable pageable);
}
