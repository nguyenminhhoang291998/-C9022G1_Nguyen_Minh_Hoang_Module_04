package com.example.repository;

import com.example.entity.AppUser;
import org.springframework.data.repository.Repository;

public interface IAppUserRepository extends Repository<AppUser,Long> {
    AppUser findByUserName (String userName);
}
