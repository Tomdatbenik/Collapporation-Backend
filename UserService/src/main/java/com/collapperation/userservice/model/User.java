package com.collapperation.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Column;
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
    @Column(name = "id")
    private String id;
    @NotNull
    @Length(min = 0, max = 256)
    @Column(name = "username")
    private String username;
    @Length(min = 0, max = 256)
    @Column(name = "firstname")
    private String firstName;
    @Length(min = 0, max = 256)
    @Column(name = "lastname")
    private String lastName;
    @Length(min = 0, max = 2147483647)
    @Column(name = "bio", columnDefinition = "Text")
    private String bio;
    @URL
    @Column(name = "picture")
    private String picture;
    @Column(name = "functiontitle")
    private String functionTitle;
//    private String email;
}
//tags
//links
//projects

//user -> user name, image, id, role
