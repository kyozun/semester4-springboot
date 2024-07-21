package org.example.springsecurewebservicev2.dto.book;

import lombok.Getter;
import lombok.Setter;
import org.example.springsecurewebservicev2.dto.publisher.PublisherDto;

import java.util.List;

@Getter
@Setter
public class BookAndMoreDto {
    private int id;
    private String name;
    private List<PublisherDto> publishers;
}
