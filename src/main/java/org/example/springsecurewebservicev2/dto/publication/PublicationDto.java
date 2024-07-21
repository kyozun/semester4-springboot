package org.example.springsecurewebservicev2.dto.publication;

import lombok.Getter;
import lombok.Setter;
import org.example.springsecurewebservicev2.dto.book.BookDto;
import org.example.springsecurewebservicev2.dto.publisher.PublisherDto;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PublicationDto {
    private int id;
    private BookDto book;
    private PublisherDto publisher;
    private LocalDateTime publishedDate;
}
