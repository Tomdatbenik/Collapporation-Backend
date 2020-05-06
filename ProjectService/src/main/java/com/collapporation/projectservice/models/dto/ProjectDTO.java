package com.collapporation.projectservice.models.dto;

import com.collapporation.projectservice.models.Project;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO extends BasicDTO{

    public ProjectDTO(Project project) {
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

    private String description;
    private List<Object> tags;
    private List<Object> links;
    private List<Object> collaborators;
    private List<Object> comments;
    private List<Object> likes;
    private List<Object> follows;
}
