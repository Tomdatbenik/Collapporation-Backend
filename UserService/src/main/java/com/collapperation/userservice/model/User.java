package com.collapperation.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

//TODO Persistences / validation

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
public class User {
    @Id
    private String id;
    @NotNull
    @Length(min = 0, max = 256)
    private String userName;
    @Length(min = 0, max = 256)
    private String firstName;
    @Length(min = 0, max = 256)
    private String lastName;
    @Length(min = 0, max = 2147483647)
    private String bio;
    @URL
    private String picture;
}
