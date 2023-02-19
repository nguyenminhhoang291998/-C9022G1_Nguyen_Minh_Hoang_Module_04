package com.example.service.impl;

import com.example.model.dto.Dto;
import com.example.repository.IDtoRepository;
import com.example.service.IDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DtoService implements IDtoService {
    @Autowired
    IDtoRepository dtoRepository;

    @Override
    public Page<Dto> findAllDto(Pageable pageable) {
        return dtoRepository.findAll(pageable);
    }
}
