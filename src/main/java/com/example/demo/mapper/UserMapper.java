package com.example.demo.mapper;

import com.example.demo.entity.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User findByUsername(String username);

}