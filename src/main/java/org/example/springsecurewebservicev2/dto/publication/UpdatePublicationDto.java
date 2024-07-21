package org.example.springsecurewebservicev2.dto.publication;

import lombok.Getter;
import lombok.Setter;
import org.example.springsecurewebservicev2.entity.Book;
import org.example.springsecurewebservicev2.entity.Publisher;

@Getter
@Setter
public class UpdatePublicationDto {
    private int book_id;
    private int publisher_id;
}
