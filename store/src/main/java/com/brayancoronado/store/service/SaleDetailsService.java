package com.brayancoronado.store.service;

import com.brayancoronado.store.entity.SaleDetails;

import java.util.List;

public interface SaleDetailsService {

    List<SaleDetails> findAll();
    SaleDetails findById(Integer id);
    SaleDetails save(SaleDetails saleDetail);
    SaleDetails update(Integer id, SaleDetails saleDetail);
    void deleteById(Integer id);

}