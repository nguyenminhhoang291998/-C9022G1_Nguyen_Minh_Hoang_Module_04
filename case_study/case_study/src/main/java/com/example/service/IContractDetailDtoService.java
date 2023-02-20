package com.example.service;


import com.example.dto.ContractDetailDto;

import java.util.List;

public interface IContractDetailDtoService {
    List<ContractDetailDto> findAll(int id);
}
