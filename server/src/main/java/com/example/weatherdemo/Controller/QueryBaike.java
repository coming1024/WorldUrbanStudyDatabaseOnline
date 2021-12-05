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
public class QueryBaike {
    @Autowired
    HttpClient httpClient;

    @RequestMapping(value = "baike/{city}")//接口
    @CrossOrigin
    public String baike(@PathVariable("city") String city){
        String url = "http://yuanxiapi.cn/api/Encyclopedia/?text=" + city;
        RequestMethod method = RequestMethod.GET;
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        return httpClient.client(url,method,params);
    }
}