package org.example.springsecurewebservicev2.services.serviceImplement;

import org.example.springsecurewebservicev2.dto.publisher.CreatePublisherDto;
import org.example.springsecurewebservicev2.dto.publisher.PublisherAndMoreDto;
import org.example.springsecurewebservicev2.dto.publisher.UpdatePublisherDto;
import org.example.springsecurewebservicev2.entity.Publisher;
import org.example.springsecurewebservicev2.mapper.PublisherMapper;
import org.example.springsecurewebservicev2.repository.PublisherRepository;
import org.example.springsecurewebservicev2.services.PublisherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImplement implements PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherServiceImplement(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<PublisherAndMoreDto> getAllPublishers() {
        List<Publisher> publishers = publisherRepository.findAll();
        List<PublisherAndMoreDto> publisherAndMoreDtoList = PublisherMapper.INSTANCE.publisherListToPublisherAndMoreListDto(publishers);
        return publisherAndMoreDtoList;
    }

    @Override
    public PublisherAndMoreDto getPublisherById(int id) {
        Publisher publisher = publisherRepository.findById(id).orElse(null);
        PublisherAndMoreDto publisherDto = PublisherMapper.INSTANCE.publisherToPublisherAndMoreDto(publisher);
        return publisherDto;
    }

    @Override
    public void createPublisher(CreatePublisherDto createPublisherDto) {
        Publisher publisher = PublisherMapper.INSTANCE.createPublisherDtoToPublisher(createPublisherDto);
        publisherRepository.save(publisher);
    }

    @Override
    public void updatePublisher(int id, UpdatePublisherDto updatePublisherDto) {

    }

    @Override
    public void deletePublisher(int id) {

    }
}
