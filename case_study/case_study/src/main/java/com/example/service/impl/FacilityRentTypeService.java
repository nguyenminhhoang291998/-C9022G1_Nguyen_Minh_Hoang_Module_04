package com.example.service.impl;

import com.example.model.FacilityType;
import com.example.model.RentType;
import com.example.repository.IFacilityRentTypeRepository;
import com.example.service.IFacilityRentTypeService;
import com.example.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityRentTypeService implements IFacilityRentTypeService {
    @Autowired
    IFacilityRentTypeRepository facilityRentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return facilityRentTypeRepository.findAll();
    }
}
