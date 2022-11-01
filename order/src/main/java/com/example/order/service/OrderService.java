package com.example.order.service;


import com.example.order.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    private final RestTemplate restTemplate;
    @Autowired
    public OrderService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Book getBook(Long id) {
        String url = "http://localhost:8081/info/"+id;
        return this.restTemplate.getForObject(url, Book.class);
    }

    public Book setNewCount(Integer cost,Long id) {
        String url = "http://localhost:8081/info/count/"+id+"?count="+cost;
        return this.restTemplate.getForObject(url,Book.class);
    }


}
