package org.example.springsecurewebservicev2.controller;

import org.example.springsecurewebservicev2.entity.Book;
import org.example.springsecurewebservicev2.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController extends BookService {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();

    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }


    @PostMapping
    public void createBook(Book book) {
        bookService.createBook(book);
    }


//    @PostMapping("/{id}")
//    public String updateBook(Long id) {
//        book.setId(id);
//        bookService.createBook(book);
//    }

    @DeleteMapping("{id}")
    public void deleteBook(Long id) {
        bookService.deleteBook(id);
    }
}
