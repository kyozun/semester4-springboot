package org.example.springsecurewebservicev2.repository;

import org.example.springsecurewebservicev2.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
