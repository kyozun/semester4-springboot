package org.example.springsecurewebservicev2.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.example.springsecurewebservicev2.dto.publisher.CreatePublisherDto;
import org.example.springsecurewebservicev2.dto.publisher.PublisherAndMoreDto;
import org.example.springsecurewebservicev2.dto.publisher.PublisherDto;
import org.example.springsecurewebservicev2.dto.publisher.UpdatePublisherDto;
import org.example.springsecurewebservicev2.services.serviceImplement.PublisherServiceImplement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {
    private final PublisherServiceImplement publisherServiceImplement;

    public PublisherController(PublisherServiceImplement publisherServiceImplement) {
        this.publisherServiceImplement = publisherServiceImplement;
    }

    @GetMapping
    public List<PublisherAndMoreDto> getAllPublishers() {
        return publisherServiceImplement.getAllPublishers();

    }

    @GetMapping("/{id}")
    public PublisherAndMoreDto getPublisherById(@PathVariable int id) {
        return publisherServiceImplement.getPublisherById(id);
    }


    @PostMapping
    public void createPublisher(@RequestBody CreatePublisherDto createPublisherDto, HttpServletResponse response) {
        publisherServiceImplement.createPublisher(createPublisherDto);
        /*Trả về 201*/
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @PutMapping("/{id}")
    public void updatePublisher(@PathVariable int id, @RequestBody UpdatePublisherDto updatePublisherDto, HttpServletResponse response) {
        publisherServiceImplement.updatePublisher(id, updatePublisherDto);
        /*Trả về 204*/
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @DeleteMapping("{id}")
    public void deletePublisher(@PathVariable int id) {
        publisherServiceImplement.deletePublisher(id);
    }
}
