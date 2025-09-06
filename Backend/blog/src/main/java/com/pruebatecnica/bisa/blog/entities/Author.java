package com.pruebatecnica.bisa.blog.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @NotNull
    private String firstName;

    @NotBlank
    @NotNull
    private String lastName;

    @NotBlank
    @NotNull
    private String secondLastName;

    @NotBlank
    @NotNull
    private String birthday;

    @NotBlank
    @NotNull
    private String residenceCountry;

    @NotBlank
    @NotNull
    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
            message = "Invalid email format"
    )
    private String email;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Blog> blogs;

}
