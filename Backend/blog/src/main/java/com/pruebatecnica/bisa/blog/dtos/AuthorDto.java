package com.pruebatecnica.bisa.blog.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDto {
    private long id;

    private String firstName;

    private String lastName;

    private String secondLastName;

    private String birthday;

    private String residenceCountry;

    private String email;
}
