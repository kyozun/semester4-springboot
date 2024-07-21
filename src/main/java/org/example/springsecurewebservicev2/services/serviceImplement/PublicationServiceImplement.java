package org.example.springsecurewebservicev2.services.serviceImplement;

import org.example.springsecurewebservicev2.dto.publication.CreatePublicationDto;
import org.example.springsecurewebservicev2.dto.publication.PublicationDto;
import org.example.springsecurewebservicev2.dto.publication.UpdatePublicationDto;
import org.example.springsecurewebservicev2.entity.Book;
import org.example.springsecurewebservicev2.entity.BookPublisher;
import org.example.springsecurewebservicev2.entity.Publisher;
import org.example.springsecurewebservicev2.mapper.PublicationMapper;
import org.example.springsecurewebservicev2.repository.BookPublisherRepository;
import org.example.springsecurewebservicev2.services.PublicationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationServiceImplement implements PublicationService {
    private final BookPublisherRepository bookPublisherRepository;

    public PublicationServiceImplement(BookPublisherRepository bookPublisherRepository) {
        this.bookPublisherRepository = bookPublisherRepository;
    }

    @Override
    public List<PublicationDto> getAllPublications() {
        List<BookPublisher> bookPublishers = bookPublisherRepository.findAll();
        List<PublicationDto> publicationDtoList = PublicationMapper.INSTANCE.BookPublisherListToPublicationDtoList(bookPublishers);

        return publicationDtoList;
    }

    @Override
    public PublicationDto getPublicationById(int id) {
        BookPublisher bookPublisher = bookPublisherRepository.findById(id).orElse(null);
        PublicationDto publicationDto = PublicationMapper.INSTANCE.BookPublisherToPublicationDto(bookPublisher);
        return publicationDto;
    }

    @Override
    public void createPublication(CreatePublicationDto createPublicationDto) {
        BookPublisher bookPublisher = PublicationMapper.INSTANCE.createPublicationDtoToBookPublisher(createPublicationDto);
        bookPublisherRepository.save(bookPublisher);
    }

    @Override
    public void updatePublication(int id, UpdatePublicationDto updatePublicationDto) {
        /*Tìm và Update*/
        BookPublisher bookPublisher = bookPublisherRepository.findById(id).orElse(null);

        Publisher publisher = new Publisher();
        publisher.setId(updatePublicationDto.getPublisher_id());

        Book book = new Book();
        book.setId(updatePublicationDto.getBook_id());

        bookPublisher.setPublisher(publisher);
        bookPublisher.setBook(book);

        bookPublisherRepository.save(bookPublisher);

    }

    @Override
    public void deletePublication(int id) {

    }
}
