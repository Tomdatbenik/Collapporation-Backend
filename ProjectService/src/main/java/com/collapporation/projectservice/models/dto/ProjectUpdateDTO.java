package com.collapporation.projectservice.models.dto;

import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.ProjectStatus;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
public class ProjectUpdateDTO{

    public ProjectUpdateDTO(Project project) {
        if(project != null)
        {
            id = project.getId();
            title = project.getTitle();
            description = project.getDescription();
            smallDescription = project.getSmallDescription();
            status = project.getStatus();
            img = project.getImg();
            ownerId = project.getOwnerId();
        }
    }

    private String id;
    private String title;
    private String description;
    private String smallDescription;
    private ProjectStatus status;
    private String img;
    private String ownerId;
}
