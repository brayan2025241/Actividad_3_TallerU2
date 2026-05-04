package com.brayancoronado.store.service;

import com.brayancoronado.store.entity.Sales;
import com.brayancoronado.store.repository.SalesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImplement implements SalesService {

    private final SalesRepository salesRepository;

    public SalesServiceImplement(SalesRepository salesRepository){
        this.salesRepository = salesRepository;
    }

    @Override
    public List<Sales> findAll(){
        return salesRepository.findAll();
    }

    @Override
    public Sales findById(Integer id) {
        return salesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale record not found with id: " + id));
    }

    @Override
    public Sales save(Sales sale) {
        sale.setSaleId(null);
        return salesRepository.save(sale);
    }

    @Override
    public Sales update(Integer id, Sales sale) {
        Sales existingSale = findById(id);

        existingSale.setSaleDate(sale.getSaleDate());
        existingSale.setTotal(sale.getTotal());
        existingSale.setCustomer(sale.getCustomer());
        existingSale.setUser(sale.getUser());
        existingSale.setStatusSale(sale.getStatusSale());

        return salesRepository.save(existingSale);
    }

    @Override
    public void deleteById(Integer id){
        Sales existingSale = findById(id);
        salesRepository.delete(existingSale);
    }
}