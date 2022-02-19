package com.example.hello.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserGateway {

    //RestTemplate เป็นของ spring boot เอาไว้ยิง api : ยิง api = gateway
    @Autowired
    private RestTemplate restTemplate;
    private String baseUrl;

    @Autowired
    public UserGateway(@Value("${base_url}") String baseUrl){
        this.baseUrl = baseUrl;
    }

    public UserResponse getUserById(int id){
        UserResponse response = restTemplate.getForObject(this.baseUrl+"users/"+id, UserResponse.class);
        return response;
    }
}
