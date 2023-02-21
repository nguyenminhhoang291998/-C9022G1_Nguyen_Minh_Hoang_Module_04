package com.example.repository;

import com.example.model.User;
import org.springframework.data.repository.Repository;

public interface IUserRepository extends Repository<User,Long> {
    User findByUserName(String userName);
}
