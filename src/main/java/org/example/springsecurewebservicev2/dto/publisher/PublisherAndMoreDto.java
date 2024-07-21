package org.example.springsecurewebservicev2.dto.publisher;

import lombok.Getter;
import lombok.Setter;
import org.example.springsecurewebservicev2.dto.book.BookDto;

import java.util.List;

@Getter
@Setter
public class PublisherAndMoreDto {
    private int id;
    private String name;
    private List<BookDto> books;
}
