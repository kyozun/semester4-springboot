package org.example.springsecurewebservicev2.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<BookPublisher> bookPublishers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BookPublisher> getBookPublishers() {
        return bookPublishers;
    }

    public void setBookPublishers(Set<BookPublisher> bookPublishers) {
        this.bookPublishers = bookPublishers;
    }
}
