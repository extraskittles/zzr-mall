package com.zzr.mall.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.params.Params;

import java.util.HashMap;
import java.util.Map;

public class HttpUtils2 {
    public static Map sendGet(String url){
        RestTemplate client = new RestTemplate();
        Map body = client.getForObject(url, Map.class);
        return body;
    }
    public static Map sendPost(String url,HttpEntity<MultiValueMap<String,String>> request){
        return null;
    }

    public static void main(String[] args) {
        /*String url="http://note.zhouzhaorong.xyz/selectDocuments";
        Map map = HttpUtils2.sendGet(url);
        System.out.println(map);*/

        String url="http://note.zhouzhaorong.xyz/addDocument";
        Map<String,String> map=new HashMap<>();
        map.put("html","44");
        map.put("title","ccc");
        Gson gson = new Gson();
        String params = gson.toJson(map, Map.class);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity(params,headers);
        RestTemplate client = new RestTemplate();
        Map body = client.postForObject(url,request,Map.class);
        System.out.println(body);


    }
}
