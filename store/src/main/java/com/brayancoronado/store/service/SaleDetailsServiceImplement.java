package com.brayancoronado.store.service;

import com.brayancoronado.store.entity.SaleDetails;
import com.brayancoronado.store.repository.SaleDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleDetailsServiceImplement implements SaleDetailsService {

    private final SaleDetailsRepository saleDetailsRepository;

    public SaleDetailsServiceImplement(SaleDetailsRepository saleDetailsRepository) {
        this.saleDetailsRepository = saleDetailsRepository;
    }

    @Override
    public List<SaleDetails> findAll() {
        return saleDetailsRepository.findAll();
    }

    @Override
    public SaleDetails findById(Integer id) {
        return saleDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale Detail not found with id: " + id));
    }

    @Override
    public SaleDetails save(SaleDetails saleDetail) {
        saleDetail.setSaleDetailId(null);
        return saleDetailsRepository.save(saleDetail);
    }

    @Override
    public SaleDetails update(Integer id, SaleDetails saleDetail) {
        SaleDetails existingDetail = findById(id);

        existingDetail.setSale(saleDetail.getSale());
        existingDetail.setProduct(saleDetail.getProduct());
        existingDetail.setQuantity(saleDetail.getQuantity());
        existingDetail.setUnitPrice(saleDetail.getUnitPrice());
        existingDetail.setSubtotal(saleDetail.getSubtotal());

        return saleDetailsRepository.save(existingDetail);
    }

    @Override
    public void deleteById(Integer id) {
        SaleDetails existingDetail = findById(id);
        saleDetailsRepository.delete(existingDetail);
    }
}