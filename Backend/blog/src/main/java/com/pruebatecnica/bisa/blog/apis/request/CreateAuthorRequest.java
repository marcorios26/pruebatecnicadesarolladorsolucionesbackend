package com.pruebatecnica.bisa.blog.apis.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class CreateAuthorRequest {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Second last name is required")
    private String secondLastName;

    @NotNull(message = "Birthday is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @NotBlank(message = "Residence country is required")
    private String residenceCountry;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

}
