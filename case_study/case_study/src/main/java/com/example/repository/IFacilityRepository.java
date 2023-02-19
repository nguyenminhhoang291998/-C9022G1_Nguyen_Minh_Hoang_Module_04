package com.example.repository;

import com.example.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    @Query(value = "select * from facility where name like :name and facility_type_id = :id and flag = true",nativeQuery = true)
    Page<Facility> findByNameAndFacilityTypeId (@Param("name") String name, @Param("id") int facilityTypeId, Pageable pageable);

    @Query(value = "select * from facility where name like :name and flag = true",nativeQuery = true)
    Page<Facility> findByName (@Param("name") String name, Pageable pageable);

    @Query(value = "select * from facility where flag = true",nativeQuery = true)
    List<Facility> findAll();
}
