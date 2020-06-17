package com.collapporation.projectservice.event;

import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.dto.ProjectDTO;
import com.collapporation.projectservice.models.dto.ProjectUpdateDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectUpdateEvent extends Event{
    private ProjectUpdateDTO project;

    public ProjectUpdateEvent(ProjectUpdateDTO project) {
        this.project = project;
    }
}
