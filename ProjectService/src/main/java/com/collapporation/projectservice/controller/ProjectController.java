package com.collapporation.projectservice.controller;

import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.dto.ProjectDTO;
import com.collapporation.projectservice.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private final ProjectService projectService;

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable("projectId") String projectId) {
        final ProjectDTO project = new ProjectDTO(projectService.getProject(projectId));

        if(project == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            //TODO fill project with tags links comments etc.
        }

        return new ResponseEntity(project, HttpStatus.OK);
    }
}
