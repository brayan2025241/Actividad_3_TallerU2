package com.brayancoronado.store.service;

import com.brayancoronado.store.entity.Customers;

import java.util.List;

public interface CustomersService {

    List<Customers> findAll();
    Customers findById(Integer id);
    Customers save(Customers customers);
    Customers update(Integer id, Customers customers);
    void deleteById(Integer id);

}