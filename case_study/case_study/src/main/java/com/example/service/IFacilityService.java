package com.example.service;

import com.example.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> search(String name, int facilityType, Pageable pageable);
    List<Facility> findAll();

    void save(Facility facility);

    Facility findById(int id);
}
