package com.example.service.impl;

import com.example.model.AttachFacility;
import com.example.repository.IAttachFacilityRepository;
import com.example.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    IAttachFacilityRepository attachFacilityRepository;
    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }
}
