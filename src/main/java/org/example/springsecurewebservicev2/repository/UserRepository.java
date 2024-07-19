package org.example.springsecurewebservicev2.repository;

import org.example.springsecurewebservicev2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

