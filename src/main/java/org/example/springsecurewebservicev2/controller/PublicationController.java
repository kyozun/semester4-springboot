package org.example.springsecurewebservicev2.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.example.springsecurewebservicev2.dto.publication.CreatePublicationDto;
import org.example.springsecurewebservicev2.dto.publication.PublicationDto;
import org.example.springsecurewebservicev2.dto.publication.UpdatePublicationDto;
import org.example.springsecurewebservicev2.services.serviceImplement.PublicationServiceImplement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publications")
public class PublicationController {

    private final PublicationServiceImplement publicationServiceImplement;

    public PublicationController(PublicationServiceImplement publicationServiceImplement) {
        this.publicationServiceImplement = publicationServiceImplement;
    }

    @GetMapping
    public List<PublicationDto> getAllPublications() {
        return publicationServiceImplement.getAllPublications();

    }

    @GetMapping("/{id}")
    public PublicationDto getPublicationById(@PathVariable int id) {
        return publicationServiceImplement.getPublicationById(id);
    }


    @PostMapping
    public void createPublication(@RequestBody CreatePublicationDto createPublicationDto, HttpServletResponse response) {
        publicationServiceImplement.createPublication(createPublicationDto);
        /*Trả về 201*/
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @PutMapping("/{id}")
    public void updatePublication(@PathVariable int id, @RequestBody UpdatePublicationDto updatePublicationDto, HttpServletResponse response) {
        publicationServiceImplement.updatePublication(id, updatePublicationDto);
        /*Trả về 204*/
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @DeleteMapping("{id}")
    public void deletePublication(@PathVariable int id) {
        publicationServiceImplement.deletePublication(id);
    }

}
