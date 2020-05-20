package com.collapporation.projectservice.event;

import com.collapporation.projectservice.models.Project;
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
