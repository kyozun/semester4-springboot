package org.example.springsecurewebservicev2.repository;

import org.example.springsecurewebservicev2.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
