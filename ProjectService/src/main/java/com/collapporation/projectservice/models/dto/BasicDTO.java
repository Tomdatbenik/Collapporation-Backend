package com.collapporation.projectservice.models.dto;

import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.ProjectStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class BasicDTO {
    public BasicDTO(Project project) {
        id = project.getId();
        title = project.getTitle();
        smallDescription = project.getSmallDescription();
        status = project.getStatus();
        img = project.getImg();
        owner = project.getOwnerId();
        created = project.getCreated();
    }

    @JsonProperty("id")
    protected String id;
    @JsonProperty("title")
    protected String title;
    @JsonProperty("smallDescription")
    protected String smallDescription;
    @JsonProperty("status")
    protected ProjectStatus status;
    @JsonProperty("img")
    protected String img;
    @JsonRawValue
    @JsonProperty("owner")
    protected String owner;
    @JsonProperty("created")
    protected LocalDateTime created;
}
