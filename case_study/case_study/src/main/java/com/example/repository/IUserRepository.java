package com.example.repository;

import com.example.dto.IUserRoleDto;
import com.example.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IUserRepository extends Repository<User,Integer> {
    User findByUsername(String userName);

    @Query(value = "select * from user_role where username = :username",nativeQuery = true)
    List<IUserRoleDto> findListRoleByUsername(@Param("username") String username);

}
