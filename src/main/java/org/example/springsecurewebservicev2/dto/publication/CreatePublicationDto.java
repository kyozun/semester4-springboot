package org.example.springsecurewebservicev2.dto.publication;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreatePublicationDto {
    private int book_id;
    private int publisher_id;

}
