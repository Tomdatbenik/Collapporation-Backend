package com.collapporation.projectservice.models.dto;

import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public abstract class BasicDTO {

    public BasicDTO(Project project) {
        id = project.getId();
        title = project.getTitle();
        smallDescription = project.getSmallDescription();
        status = project.getStatus();
        img = project.getImg();
        ownerId = project.getOwnerId();
    }

    protected String id;
    protected String title;
    protected String smallDescription;
    protected ProjectStatus status;
    protected String img;
    protected String ownerId;

    //region Getters ctrl+alt+t
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSmallDescription() {
        return smallDescription;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public String getImg() {
        return img;
    }

    public String getOwnerId() {
        return ownerId;
    }
    //endregion
}
