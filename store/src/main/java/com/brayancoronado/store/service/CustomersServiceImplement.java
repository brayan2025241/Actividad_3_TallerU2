package com.brayancoronado.store.service;

import com.brayancoronado.store.entity.Customers;
import com.brayancoronado.store.repository.CustomersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersServiceImplement implements CustomersService {

    private final CustomersRepository customersRepository;

    public CustomersServiceImplement(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Override
    public List<Customers> findAll() {
        return customersRepository.findAll();
    }

    @Override
    public Customers findById(Integer id) {
        return customersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    @Override
    public Customers save(Customers customers) {

        customers.setCustomerId(null);
        return customersRepository.save(customers);
    }

    @Override
    public Customers update(Integer id, Customers customers) {
        Customers existente = findById(id);

        existente.setFirstName(customers.getFirstName());
        existente.setLastName(customers.getLastName());
        existente.setAddress(customers.getAddress());
        existente.setStatusCustomer(customers.getStatusCustomer());

        return customersRepository.save(existente);
    }

    @Override
    public void deleteById(Integer id) {
        Customers existente = findById(id);
        customersRepository.delete(existente);
    }
}
