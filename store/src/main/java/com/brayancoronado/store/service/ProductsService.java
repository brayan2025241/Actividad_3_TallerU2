package com.brayancoronado.store.service;

import com.brayancoronado.store.entity.Products;

import java.util.List;

public interface ProductsService {

    List<Products> findAll();
    Products findById(Integer id);
    Products save(Products product);
    Products update(Integer id, Products product);
    void deleteById(Integer id);

}