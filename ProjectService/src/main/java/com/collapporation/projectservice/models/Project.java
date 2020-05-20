package com.collapporation.projectservice.models;

import com.collapporation.projectservice.models.dto.BasicDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "project")
public class Project
{
    @Id
    @JsonProperty("id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "title")
    @JsonProperty("title")
    @Length(min = 2, max = 255)
    private String title;

    @Column(name = "smalldescription")
    @JsonProperty("smallDescription")
    @Length(min = 0, max = 255)
    private String smallDescription;

    //TODO might give errors
    @Column(name = "description", columnDefinition = "TEXT")
    @JsonProperty("description")
    private String description;

    @Column(name = "status")
    @JsonProperty("status")
    private ProjectStatus status;

    //TODO might give errors
    @JsonProperty("img")
    @Column(name = "img", columnDefinition = "TEXT", length = 100000)
    @Lob
    private byte[] img;

    @Column(name = "ownerid")
    @JsonProperty("ownerId")
    private String ownerId;

    @Column(name = "created")
    @CreationTimestamp
    @JsonProperty("created")
    private LocalDateTime created;

    //TODO think about this: UpdateTimestamp
    public Project(BasicDTO project)
    {
        id = project.getId();
        title = project.getTitle();
        smallDescription = project.getSmallDescription();
        status = project.getStatus();
        ownerId = project.getOwner();
        img = project.getImg();
        created = project.getCreated();
        description = "";
    }
}
