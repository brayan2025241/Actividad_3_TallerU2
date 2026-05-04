package com.brayancoronado.store.repository;

import com.brayancoronado.store.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
