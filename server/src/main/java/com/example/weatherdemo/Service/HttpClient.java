package com.example.weatherdemo.Service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpClient {

    public String client(String url, RequestMethod method, MultiValueMap<String,String> params){
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response1 = template.getForEntity(url,String.class);
        return response1.getBody();
    }
}
