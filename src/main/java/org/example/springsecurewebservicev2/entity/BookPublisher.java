package org.example.springsecurewebservicev2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "book_publisher")
@Getter
@Setter
public class BookPublisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private LocalDateTime publishedDate = LocalDateTime.now();;

    @ManyToOne()
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne()
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;


}
