package com.example.weatherdemo.Controller;

import com.example.weatherdemo.Service.HttpClient;
import okhttp3.internal.http.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
@RestController
public class QueryLocation {
    @Autowired
    HttpClient httpClient;

    @RequestMapping(value = "location/{city}")//接口
    @CrossOrigin
    public String location(@PathVariable("city") String city){
        String ak="a5Auh2TX8YYnju1PCNS3aHtGOml30mKN";
        String url = "https://api.map.baidu.com/geocoding/v3/?address="+city+"&output=json&ak="+ak+"&callback=showLocation"+city;
        RequestMethod method = RequestMethod.GET;
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        return httpClient.client(url,method,params);
    }
}
