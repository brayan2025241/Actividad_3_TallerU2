package com.brayancoronado.store.repository;

import com.brayancoronado.store.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {

}
