package com.example.service;

import com.example.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Page<Facility> search(String name, int facilityType, Pageable pageable);

    void save(Facility facility);

    Facility findById(int id);
}
