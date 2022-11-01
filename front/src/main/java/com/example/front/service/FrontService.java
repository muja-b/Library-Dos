package com.example.front.service;

import com.example.front.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class FrontService {

    private final RestTemplate restTemplate;

    @Autowired
    public FrontService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<String> searchByName(String name){
        String url = "http://localhost:8081/search/name/"+name;

        return this.restTemplate.getForObject(url,List.class);

    }

    public List<String> searchByTopic(String topic) {
        String url = "http://localhost:8081/search/topic/"+topic;

        return this.restTemplate.getForObject(url,List.class);
    }

    public List<Book> infoByTopic(String topic) {
        String url = "http://localhost:8081/info/topic/"+topic;

        return this.restTemplate.getForObject(url,List.class);
    }

    public List<Book> info(String name) {
        String url = "http://localhost:8081/info/name/"+name;

        return this.restTemplate.getForObject(url,List.class);
    }


    public Book findById(Long id) {
        String url = "http://localhost:8081/info/"+id;

        return this.restTemplate.getForObject(url,Book.class);
    }

    public Book editPrice(Long id,Double cost){
        String url = "http://localhost:8081/info/cost/"+id+"?cost="+cost;

        return this.restTemplate.getForObject(url,Book.class);
    }

    public Book editCount(Long id, Long count) {
        String url = "http://localhost:8081/info/count/"+id+"?count="+count;
        return this.restTemplate.getForObject(url,Book.class);
    }

    public Book purchase(Long id) {
        String url = "http://localhost:8082/purchase/"+id;
        return this.restTemplate.getForObject(url,Book.class);
    }
}
