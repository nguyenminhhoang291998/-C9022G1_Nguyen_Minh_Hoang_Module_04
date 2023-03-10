package com.example.service.impl;

import com.example.model.Facility;
import com.example.repository.IFacilityRepository;
import com.example.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;
    @Override
    public Page<Facility> search(String name, int facilityTypeId, Pageable pageable) {
        if(facilityTypeId == 0){
            return facilityRepository.findByName("%"+name+"%",pageable);
        }
        return facilityRepository.findByNameAndFacilityTypeId("%"+name+"%", facilityTypeId, pageable);
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public boolean save(Facility facility) {
        if(facilityRepository.checkExistsSave(facility.getName())!=null){
            return false;
        }
        facility.setFlag(true);
        facilityRepository.save(facility);
        return true;
    }

    @Override
    public boolean update(Facility facility) {
        if(facilityRepository.checkExistsUpdate(facility.getId(), facility.getName())!=null){
            return false;
        }
        facility.setFlag(true);
        facilityRepository.save(facility);
        return true;
    }

    @Override
    public void delete(Facility facility) {
        facility.setFlag(false);
        facilityRepository.save(facility);
    }


    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id).orElse(new Facility());
    }
}
