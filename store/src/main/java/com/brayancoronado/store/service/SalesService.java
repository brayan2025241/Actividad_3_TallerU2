package com.brayancoronado.store.service;

import com.brayancoronado.store.entity.Sales;

import java.util.List;

public interface SalesService {

    List<Sales> findAll();
    Sales findById(Integer id);
    Sales save(Sales sale);
    Sales update(Integer id, Sales sale);
    void deleteById(Integer id);

}