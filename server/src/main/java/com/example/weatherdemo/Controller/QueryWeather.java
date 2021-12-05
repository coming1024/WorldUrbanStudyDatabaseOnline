package com.example.weatherdemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;

import java.util.HashMap;
import java.util.Map;

@RestController
public class QueryWeather {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/weather/{city}", method = RequestMethod.GET)//接口
    @CrossOrigin
    public String extern(@PathVariable("city") String city){
        String apiURL = "http://wthrcdn.etouch.cn/weather_mini?city=" + city;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiURL, String.class);

        if(200==responseEntity.getStatusCodeValue()){
            return responseEntity.getBody();
        }else{
            return "error with code : " + responseEntity.getStatusCodeValue();
        }
    }


}
