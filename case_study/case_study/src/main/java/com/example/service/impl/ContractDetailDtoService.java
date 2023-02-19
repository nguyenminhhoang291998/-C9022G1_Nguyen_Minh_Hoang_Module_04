package com.example.service.impl;

import com.example.model.dto.ContractDetailDto;
import com.example.repository.IContractDetailDtoRepository;
import com.example.service.IContractDetailDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailDtoService implements IContractDetailDtoService {
    @Autowired
    IContractDetailDtoRepository contractDetailDtoRepository;
    @Override
    public List<ContractDetailDto> findAll(int id) {
        return contractDetailDtoRepository.findAll(id);
    }
}
