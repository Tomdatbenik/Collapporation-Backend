package com.collapporation.projectservice.controller;

import com.collapporation.projectservice.kafka.dispatcher.IDispatcher;
import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.ProjectStatus;
import com.collapporation.projectservice.models.dto.ProjectDTO;
import com.collapporation.projectservice.service.ProjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private final ProjectService projectService;

    private final Logger logger = LoggerFactory.getLogger(ProjectController.class);

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

    @PostMapping("/create")
    public ResponseEntity createProject(@RequestBody Project project)
    {
        projectService.createProject(project);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/update/status")
    public ResponseEntity conceptToProject(@PathVariable("projectId") String projectId, @PathVariable("status") ProjectStatus status)
    {
        projectService.updateStatus(projectId,status);

        return new ResponseEntity(HttpStatus.OK);
    }
}
