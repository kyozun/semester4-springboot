package org.example.springsecurewebservicev2.mapper;

import org.example.springsecurewebservicev2.dto.publication.CreatePublicationDto;
import org.example.springsecurewebservicev2.dto.publication.PublicationDto;
import org.example.springsecurewebservicev2.dto.publication.UpdatePublicationDto;
import org.example.springsecurewebservicev2.entity.BookPublisher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PublicationMapper {
    PublicationMapper INSTANCE = Mappers.getMapper(PublicationMapper.class);

    /*to Dto*/
    @Mapping(source = "book", target = "book")
    @Mapping(source = "publisher", target = "publisher")
    @Mapping(source = "publishedDate", target = "publishedDate")
    PublicationDto BookPublisherToPublicationDto(BookPublisher bookPublisher);

    /*to Dto*/
    List<PublicationDto> BookPublisherListToPublicationDtoList(List<BookPublisher> bookPublisherList);

    /*to Entity*/
    @Mapping(source = "book_id", target = "book.id")
    @Mapping(source = "publisher_id", target = "publisher.id")
    BookPublisher createPublicationDtoToBookPublisher(CreatePublicationDto createPublicationDto);


    /*to Entity*/
    @Mapping(source = "book_id", target = "book.id", ignore = true)
    @Mapping(source = "publisher_id", target = "publisher.id", ignore = true)
    BookPublisher updatePublicationDtoToBookPublisher(UpdatePublicationDto updatePublicationDto, @MappingTarget BookPublisher bookPublisher);

}


/*
* Dto
* DtoList
* Entity
* */