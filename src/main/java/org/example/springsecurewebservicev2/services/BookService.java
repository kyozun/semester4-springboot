package org.example.springsecurewebservicev2.services;

import org.example.springsecurewebservicev2.dto.book.BookAndMoreDto;
import org.example.springsecurewebservicev2.dto.book.CreateBookDto;
import org.example.springsecurewebservicev2.dto.book.UpdateBookDto;

import java.util.List;

public interface BookService {
    public List<BookAndMoreDto> getAllBooks();

    public BookAndMoreDto getBookById(int id);

    public void createBook(CreateBookDto createBookDto);

    public void updateBook(int id, UpdateBookDto updateBookDto);

    public void deleteBook(int id);

}
