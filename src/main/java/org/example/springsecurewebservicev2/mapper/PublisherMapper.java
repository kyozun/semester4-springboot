package org.example.springsecurewebservicev2.mapper;

import org.example.springsecurewebservicev2.dto.book.BookDto;
import org.example.springsecurewebservicev2.dto.publisher.CreatePublisherDto;
import org.example.springsecurewebservicev2.dto.publisher.PublisherAndMoreDto;
import org.example.springsecurewebservicev2.entity.BookPublisher;
import org.example.springsecurewebservicev2.entity.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper()
public interface PublisherMapper {
    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    /*to Dto*/
    @Mapping(source = "bookPublishers", target = "books")
    PublisherAndMoreDto publisherToPublisherAndMoreDto(Publisher publisher);

    /*to Dto*/
    @Mapping(source = "book.id", target = "id")
    @Mapping(source = "book.name", target = "name")
    BookDto bookPublisherToBookDto(BookPublisher bookPublisher);

    /*to Dto*/
    List<PublisherAndMoreDto> publisherListToPublisherAndMoreListDto(List<Publisher> publisherList);

    /*to Entity*/
    @Mapping(source = "id", target = "book.id")
    @Mapping(source = "name", target = "book.name")
    BookPublisher bookDtoToBookPublisher(BookDto bookDto);

    /*to Entity*/
    @Mapping(source = "name", target = "name")
    Publisher createPublisherDtoToPublisher(CreatePublisherDto createPublisherDto);



}
