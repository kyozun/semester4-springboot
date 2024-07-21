package org.example.springsecurewebservicev2.services;

import org.example.springsecurewebservicev2.dto.publication.CreatePublicationDto;
import org.example.springsecurewebservicev2.dto.publication.PublicationDto;
import org.example.springsecurewebservicev2.dto.publication.UpdatePublicationDto;
import org.example.springsecurewebservicev2.entity.BookPublisher;

import java.util.List;

public interface PublicationService {
    public List<PublicationDto> getAllPublications();

    public PublicationDto getPublicationById(int id);

    public void createPublication(CreatePublicationDto createPublicationDto);

    public void updatePublication(int id, UpdatePublicationDto updatePublicationDto);

    public void deletePublication(int id);

}
