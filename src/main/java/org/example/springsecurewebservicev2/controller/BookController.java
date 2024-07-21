package org.example.springsecurewebservicev2.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.example.springsecurewebservicev2.dto.book.BookAndMoreDto;
import org.example.springsecurewebservicev2.dto.book.CreateBookDto;
import org.example.springsecurewebservicev2.dto.book.UpdateBookDto;
import org.example.springsecurewebservicev2.services.serviceImplement.BookServiceImplement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookServiceImplement bookServiceImplement;

    public BookController(BookServiceImplement bookServiceImplement) {
        this.bookServiceImplement = bookServiceImplement;
    }

    @GetMapping
    public List<BookAndMoreDto> getAllBooks() {

        return bookServiceImplement.getAllBooks();

    }

    @GetMapping("/{id}")
    public BookAndMoreDto getBookById(@PathVariable int id) {
        return bookServiceImplement.getBookById(id);
    }


    @PostMapping
    public void createBook(@RequestBody CreateBookDto createBookDto, HttpServletResponse response) {
        bookServiceImplement.createBook(createBookDto);
        /*Trả về 201*/
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable int id, @RequestBody UpdateBookDto updateBookDto, HttpServletResponse response) {
        bookServiceImplement.updateBook(id, updateBookDto);
        /*Trả về 204*/
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable int id) {
        bookServiceImplement.deleteBook(id);
    }
}
