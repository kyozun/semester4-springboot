package org.example.springsecurewebservicev2.services;

import org.example.springsecurewebservicev2.entity.Book;
import org.example.springsecurewebservicev2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

        public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void createBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
