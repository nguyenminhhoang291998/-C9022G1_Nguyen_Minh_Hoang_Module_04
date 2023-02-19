package com.example.service;

import com.example.model.dto.Dto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDtoService {

    Page<Dto> findAllDto(Pageable pageable);
}
