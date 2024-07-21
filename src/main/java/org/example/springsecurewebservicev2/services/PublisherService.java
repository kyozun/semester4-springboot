package org.example.springsecurewebservicev2.services;

import org.example.springsecurewebservicev2.dto.publisher.CreatePublisherDto;
import org.example.springsecurewebservicev2.dto.publisher.PublisherAndMoreDto;
import org.example.springsecurewebservicev2.dto.publisher.UpdatePublisherDto;

import java.util.List;

public interface PublisherService {
    public List<PublisherAndMoreDto> getAllPublishers();

    public PublisherAndMoreDto getPublisherById(int id);

    public void createPublisher(CreatePublisherDto createPublisherDto);

    public void updatePublisher(int id, UpdatePublisherDto updatePublisherDto);

    public void deletePublisher(int id);
}
