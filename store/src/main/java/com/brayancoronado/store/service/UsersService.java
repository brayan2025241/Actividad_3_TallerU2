package com.brayancoronado.store.service;

import com.brayancoronado.store.entity.Users;

import java.util.List;

public interface UsersService {

    List<Users> findAll();
    Users findById(Integer id);
    Users save(Users users);
    Users update(Integer id, Users users);
    void deleteById(Integer id);

}