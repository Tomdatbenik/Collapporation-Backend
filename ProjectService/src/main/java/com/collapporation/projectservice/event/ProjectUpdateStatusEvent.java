package com.collapporation.projectservice.event;

import com.collapporation.projectservice.models.ProjectStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectUpdateStatusEvent extends Event{
    private String projectId;
    private ProjectStatus status;

    public ProjectUpdateStatusEvent(String projectId, ProjectStatus status) {
        this.projectId = projectId;
        this.status = status;
    }
}
