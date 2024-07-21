package org.example.springsecurewebservicev2.mapper;

import org.example.springsecurewebservicev2.dto.book.BookAndMoreDto;
import org.example.springsecurewebservicev2.dto.book.CreateBookDto;
import org.example.springsecurewebservicev2.dto.book.UpdateBookDto;
import org.example.springsecurewebservicev2.dto.publisher.PublisherDto;
import org.example.springsecurewebservicev2.entity.Book;
import org.example.springsecurewebservicev2.entity.BookPublisher;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    /*to Dto*/
    @Mapping(source = "bookPublishers", target = "publishers")
    BookAndMoreDto bookToBookAndMoreDto(Book book);

    /*to Dto*/
    @Mapping(source = "publisher.id", target = "id")
    @Mapping(source = "publisher.name", target = "name")
    PublisherDto bookPublisherToPublisherDto(BookPublisher bookPublisher);

    /*to Dto*/
    List<BookAndMoreDto> bookListToBookAndMoreListDto(List<Book> bookList);

    /*to Entity*/
    @Mapping(source = "name", target = "name")
    Book createBookDtoToBook(CreateBookDto createBookDto);

    /*to Entity*/
    @Mapping(source = "name", target = "name")
    Book updateBookDtoToBook(UpdateBookDto updateBookDto, @MappingTarget Book book);





}
