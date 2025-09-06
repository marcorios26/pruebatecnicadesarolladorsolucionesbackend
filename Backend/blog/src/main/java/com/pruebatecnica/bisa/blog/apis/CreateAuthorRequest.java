package com.pruebatecnica.bisa.blog.apis;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAuthorRequest {

    private String firstName;

    private String lastName;

    private String secondLastName;

    private String birthday;

    private String residenceCountry;

    private String email;

}
