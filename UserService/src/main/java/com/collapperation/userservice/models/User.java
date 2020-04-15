package com.collapperation.userservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

//TODO Persistences / validation

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
public class User {
    @Id
    private String id;
    private String userName;
    private String firstName;
    private String lastName;
    private String bio;
    private String picture;
}
