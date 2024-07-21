package org.example.springsecurewebservicev2.services.serviceImplement;

import org.example.springsecurewebservicev2.dto.book.BookAndMoreDto;
import org.example.springsecurewebservicev2.dto.book.CreateBookDto;
import org.example.springsecurewebservicev2.dto.book.UpdateBookDto;
import org.example.springsecurewebservicev2.entity.Book;
import org.example.springsecurewebservicev2.mapper.BookMapper;
import org.example.springsecurewebservicev2.repository.BookRepository;
import org.example.springsecurewebservicev2.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplement implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImplement(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookAndMoreDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookAndMoreDto> bookAndMoreDtoList = BookMapper.INSTANCE.bookListToBookAndMoreListDto(books);
        return bookAndMoreDtoList;
    }

    @Override
    public BookAndMoreDto getBookById(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        BookAndMoreDto bookAndMoreDto = BookMapper.INSTANCE.bookToBookAndMoreDto(book);
        return bookAndMoreDto;
    }

    @Override
    public void createBook(CreateBookDto createBookDto) {
        Book book = BookMapper.INSTANCE.createBookDtoToBook(createBookDto);
        bookRepository.save(book);
    }

    @Override
    public void updateBook(int id, UpdateBookDto updateBookDto) {
        /*Tìm và update*/
        Book book = bookRepository.findById(id).orElse(null);
        BookMapper.INSTANCE.updateBookDtoToBook(updateBookDto, book);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

}
