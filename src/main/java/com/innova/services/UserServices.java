package com.innova.services;

import com.innova.dto.UserRegisterDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServices {

    //http://localhost:8080/rest/manueljson
    @GetMapping("/rest/manueljson")
    public String getManuelJson(){
        return "{\"adisoyadi\": \"Beytullah Zor\"}";
    }

    //http://localhost:8080/rest/dynamicsjson
    @GetMapping("/rest/dynamicsjson")
    public UserRegisterDto getDynamicsJson(){
        UserRegisterDto userRegisterDto = UserRegisterDto.builder()
                .userEmail("beytullahzor7@gmail.com")
                .userPassword("12345abc")
                .build();
        return userRegisterDto;
    }

    //http://localhost:8080/rest/mediatype
    @GetMapping(value = "/rest/mediatype", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserRegisterDto getProduces(){
        UserRegisterDto userRegisterDto = UserRegisterDto.builder()
                .userEmail("beytullahzor7@gmail.com")
                .userPassword("12345abc")
                .build();
        return userRegisterDto;
    }
}
