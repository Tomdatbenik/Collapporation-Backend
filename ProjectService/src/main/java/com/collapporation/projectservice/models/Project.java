package com.collapporation.projectservice.models;

import com.collapporation.projectservice.models.dto.BasicDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "project")
public class Project {

    public Project(BasicDTO project) {
        id = project.getId();
        title = project.getTitle();
        smallDescription = project.getSmallDescription();
        status = project.getStatus();
        ownerId = project.getOwnerId();
        img = project.getImg();
    }

    @Id
    @JsonProperty("advertId")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(unique = true)
    private String id;

    @Column
    @JsonProperty("title")
    @Length(min = 0,max = 255)
    private String title;

    @Column
    @JsonProperty("smallDescription")
    @Length(min = 0,max = 255)
    private String smallDescription;

    //TODO might give errors
    @Column(columnDefinition="TEXT")
    @JsonProperty("description")
    private String description;

    @Column
    @JsonProperty("description")
    private ProjectStatus status;

    //TODO might give errors
    @JsonProperty("description")
    @Column(columnDefinition="TEXT")
    private String img;

    @Column
    @JsonProperty("description")
    private String ownerId;

    @Column
    @JsonProperty("description")
    private LocalDateTime created;

}
