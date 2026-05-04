package com.brayancoronado.store.service;

import com.brayancoronado.store.entity.Products;
import com.brayancoronado.store.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImplement implements ProductsService {

    private final ProductsRepository productsRepository;

    public ProductsServiceImplement(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public List<Products> findAll() {
        return productsRepository.findAll();
    }

    @Override
    public Products findById(Integer id) {
        return productsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public Products save(Products product) {
        product.setProductId(null);
        return productsRepository.save(product);
    }

    @Override
    public Products update(Integer idAct, Products product) {
        Products existente = findById(idAct);

        existente.setProductName(product.getProductName());
        existente.setPrice(product.getPrice());
        existente.setStock(product.getStock());
        existente.setStatusProduct(product.getStatusProduct());

        return productsRepository.save(existente);
    }

    @Override
    public void deleteById(Integer idElim) {
        Products existente = findById(idElim);
        productsRepository.delete(existente);
    }
}