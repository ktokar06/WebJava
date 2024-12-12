package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов")
    @Column(name = "username")
    private String username;

    @Min(value = 1000, message = "Значение должно быть больще 1000")
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;


    public Person() {
    }

    public Person(String username, int yearOfBirth) {
        this.username = username;
        this.yearOfBirth = yearOfBirth;
    }

    public Person(int id,
            @NotEmpty @Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов") String username,
            @Min(value = 1000, message = "Значение должно быть больще 1000") int yearOfBirth, String password,
            String role) {
        this.id = id;
        this.username = username;
        this.yearOfBirth = yearOfBirth;
        this.password = password;
        this.role = role;
    }
}