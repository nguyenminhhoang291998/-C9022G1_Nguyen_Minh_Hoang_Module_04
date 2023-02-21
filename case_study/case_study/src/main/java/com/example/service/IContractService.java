package com.example.service;


import com.example.dto.IContractDetailDto;
import com.example.dto.IContractDto;
import com.example.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<IContractDto> findAll(Pageable pageable);

    void save(Contract contract);

    List<IContractDetailDto> findContractDetailByContractId(int id);

}
