package com.example.productservicemyproject_1.commons;

import com.example.productservicemyproject_1.dtos.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationCommons {

    private RestTemplate restTemplate;

    public AuthenticationCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean validateToken(String tokenValue) {
       ResponseEntity<UserDTO> userDTOResponse = restTemplate.postForEntity(
                "https://localhost:8181/users/validate/"+tokenValue,
                null,
                UserDTO.class);

       if(userDTOResponse.getBody() == null) {
           return false;
       }
        return true;
    }
}
