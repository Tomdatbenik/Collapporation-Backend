package com.collapporation.projectservice.models.dto;

import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.ProjectStatus;
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

    protected String id;
    protected String title;
    protected String smallDescription;
    protected ProjectStatus status;
    protected String img;
    protected String owner;
    protected LocalDateTime created;
}
