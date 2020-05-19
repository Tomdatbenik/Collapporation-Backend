package com.collapporation.likeservice.event;

import com.collapporation.likeservice.models.Project;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectUpdateEvent extends Event{
    private Project project;

    public ProjectUpdateEvent(Project project) {
        this.project = project;
    }
}
