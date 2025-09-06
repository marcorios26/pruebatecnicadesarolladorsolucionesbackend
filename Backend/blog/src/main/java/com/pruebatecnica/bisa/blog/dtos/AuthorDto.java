package com.pruebatecnica.bisa.blog.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AuthorDto {

    private String firstName;

    private String lastName;

    private String secondLastName;

    private LocalDate birthday;

    private String residenceCountry;

    private String email;
}
