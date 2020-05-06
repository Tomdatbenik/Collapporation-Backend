package com.collapporation.projectservice.models.dto;

import com.collapporation.projectservice.models.Project;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ProjectFeedDTO extends BasicDTO{
    public ProjectFeedDTO(Project project) {
        if(project != null)
        {
            title = project.getTitle();
            smallDescription = project.getSmallDescription();
            status = project.getStatus();
            img = project.getImg();
            ownerId = project.getOwnerId();
            tags = new ArrayList<>();
            likes = 2;
            follow = true;
        }
    }

    private List<Object> tags;
    private int likes;
    private boolean follow;
}
