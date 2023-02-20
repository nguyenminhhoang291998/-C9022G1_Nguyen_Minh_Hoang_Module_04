package com.example.service;


import com.example.dto.IContractDto;
import com.example.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<IContractDto> findAll(Pageable pageable);

}
