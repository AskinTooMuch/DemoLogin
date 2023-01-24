package com.example.demologin.repository;

import com.example.demologin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public Long countById(Integer id);

    public User findByEmailAndPassword(String email, String password);
}

