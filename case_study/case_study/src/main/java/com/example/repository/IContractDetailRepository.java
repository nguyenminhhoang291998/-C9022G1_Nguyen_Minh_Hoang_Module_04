package com.example.repository;

import com.example.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
}
