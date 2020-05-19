package com.collapporation.likeservice.models.dto;

import com.collapporation.likeservice.models.Project;
import lombok.NoArgsConstructor;

@NoArgsConstructor
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
            owner = project.getOwnerId();
            created = project.getCreated();
        }
    }

    private String description;
    private String tags;
    private String links;
    private String collaborators;
    private String comments;
    private String likes;
    private String follows;
}
