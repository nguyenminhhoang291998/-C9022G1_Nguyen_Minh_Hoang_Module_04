package com.example.repository;

import com.example.dto.IUserRoleDto;
import com.example.model.User;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface IUserRepository extends Repository<User,Long> {
    User findByUsername(String userName);

//    List<IUserRoleDto> findByUsername();
}
