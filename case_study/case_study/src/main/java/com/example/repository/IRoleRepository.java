package com.example.repository;

import com.example.model.Role;
import org.springframework.data.repository.Repository;

public interface IRoleRepository extends Repository<Role,Integer> {
    Role findById(int id);
}
