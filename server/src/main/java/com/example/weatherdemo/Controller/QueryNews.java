package com.example.weatherdemo.Controller;

import com.example.weatherdemo.Service.HttpClient;
import okhttp3.internal.http.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@RestController
@CrossOrigin
public class QueryNews {

    String key="99e0c1b126ba318739c265afd224bb85";

    @Autowired
    HttpClient httpClient;

    @RequestMapping(value = "society/{city}")//接口

    public String society(@PathVariable("city") String city){
        String url = "http://api.tianapi.com/areanews/index?key="+key+"&areaname=" + city;
        RequestMethod method = RequestMethod.GET;
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        return httpClient.client(url,method,params);
    }

    @RequestMapping(value = "finance/{city}")//接口
    public String finance(@PathVariable("city") String city){
        String url = "http://api.tianapi.com/caijing/index?key="+key+"&num=2&word=" + city;
        RequestMethod method = RequestMethod.GET;
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        return httpClient.client(url,method,params);
    }

    @RequestMapping(value = "environment/hnology/{city}")//接口
    public String environment(@PathVariable("city") String city){
        String url = "http://api.tianapi.com/huanbao/index?key="+key+"&num=2&word=" + city;
        RequestMethod method = RequestMethod.GET;
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        return httpClient.client(url,method,params);
    }

    @RequestMapping(value = "tec{city}")//接口
    public String technology(@PathVariable("city") String city){
        String url = "http://api.tianapi.com/sicprobe/index?key="+key+"&num=2&word=" + city;
        RequestMethod method = RequestMethod.GET;
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        return httpClient.client(url,method,params);
    }

    @RequestMapping(value = "viewspots/{city}")//接口
    public String view(@PathVariable("city") String city){
        String url = "http://api.tianapi.com/txapi/scenic/index?key="+key+"&num=6&city=" + city;
        RequestMethod method = RequestMethod.GET;
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        return httpClient.client(url,method,params);
    }

    /*@RequestMapping(value = "cityweather/{city}")//接口
    public String weather1(@PathVariable("city") String city) throws IOException, DocumentException {
        URL url = new URL("http://wthrcdn.etouch.cn/WeatherApi?city="+city);
        URLConnection conn = url.openConnection();
        //拿下网址的输入流
        InputStream is = conn.getInputStream();
        //2、创建一盒XML读取对象
        SAXReader sr = new SAXReader();
        //3、通过读取对象 读取xml数据吗，并返回文档对象
        Document doc = sr.read(is);
        //4、获取根节点
        Element root = doc.getRootElement();

        //RequestMethod method = RequestMethod.GET;
        //MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        return httpClient.client(url,method,params);

    }*/



}
