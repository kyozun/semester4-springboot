package org.example.springsecurewebservicev2.repository;

import org.example.springsecurewebservicev2.entity.BookPublisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookPublisherRepository extends JpaRepository<BookPublisher, Long> {
}
