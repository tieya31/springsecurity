package com.example.demo.service;

import com.example.demo.entity.po.User;

public interface IUserService {
    User findByUsername(String username);
}
