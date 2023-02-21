package com.example.service.impl;

import com.example.dto.IContractDetailDto;
import com.example.model.ContractDetail;
import com.example.repository.IContractDetailRepository;
import com.example.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }


}
