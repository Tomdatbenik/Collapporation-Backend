package com.collapporation.projectservice.models;

import com.collapporation.projectservice.models.Projection.IProject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "project")
public class Project implements IProject {
    @Id
    @JsonProperty("id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "title")
    @JsonProperty("title")
    @Length(min = 0, max = 255)
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
    @Column(name = "img", columnDefinition = "TEXT")
    private String img;

    @Column(name = "ownerid")
    @JsonProperty("ownerId")
    private String ownerId;

    @Column(name = "created")
    @CreationTimestamp
    @JsonProperty("created")
    private LocalDateTime created;

    //TODO think about this: UpdateTimestamp

    @Transient
    private List<Object> tags;
    @Transient
    private List<Object> links;
    @Transient
    private List<Object> collaborators;
    @Transient
    private List<Object> comments;
    @Transient
    private List<Object> likes;
    @Transient
    private List<Object> follows;

    @Override
    public List<Object> getTags() {
        return tags;
    }

    @Override
    public List<Object> getLinks() {
        return links;
    }

    @Override
    public List<Object> getCollaborators() {
        return collaborators;
    }

    @Override
    public List<Object> getComments() {
        return comments;
    }

    @Override
    public List<Object> getLikes() {
        return likes;
    }

    @Override
    public List<Object> getFollows() {
        return follows;
    }
}
