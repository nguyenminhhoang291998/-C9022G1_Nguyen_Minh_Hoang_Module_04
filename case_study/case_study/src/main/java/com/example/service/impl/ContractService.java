package com.example.service.impl;

import com.example.dto.IContractDetailDto;
import com.example.dto.IContractDto;
import com.example.model.Contract;
import com.example.repository.IContractRepository;
import com.example.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;
    @Override
    public Page<IContractDto> findAll(Pageable pageable) {
        return contractRepository.showListContract(pageable);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<IContractDetailDto> findContractDetailByContractId(int id) {
        return contractRepository.findContractDetailByContractId(id);
    }
}
