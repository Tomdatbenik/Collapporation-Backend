package com.collapporation.projectservice.models.dto;

import com.collapporation.projectservice.models.Project;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ProjectFeedDTO extends BasicDTO{
    public ProjectFeedDTO(Project project) {
        if(project != null)
        {
            id = project.getId();
            title = project.getTitle();
            smallDescription = project.getSmallDescription();
            status = project.getStatus();
            img = project.getImg();
            created = project.getCreated();
            tags = new ArrayList<>();
            likes = 2;
            follow = true;
        }
    }

//    @JsonRawValue
//    @JsonProperty("owner")
//    private String owner;
    @JsonProperty("tags")
    private List<Object> tags;
    @JsonProperty("likes")
    private int likes;
    @JsonProperty("follow")
    private boolean follow;
}
