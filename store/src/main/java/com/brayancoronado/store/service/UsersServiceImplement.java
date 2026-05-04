package com.brayancoronado.store.service;

import com.brayancoronado.store.entity.Users;
import com.brayancoronado.store.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImplement implements UsersService {

    private final UsersRepository usersRepository;

    public UsersServiceImplement(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users findById(Integer id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public Users save(Users users) {
        users.setUserId(null);
        return usersRepository.save(users);
    }

    @Override
    public Users update(Integer id, Users users) {
        Users existente = findById(id);

        existente.setUsername(users.getUsername());
        existente.setPassword_user(users.getPassword_user());
        existente.setEmail(users.getEmail());
        existente.setRole_user(users.getRole_user());
        existente.setStatus_user(users.getStatus_user());

        return usersRepository.save(existente);
    }

    @Override
    public void deleteById(Integer id) {
        Users existente = findById(id);
        usersRepository.delete(existente);
    }
}