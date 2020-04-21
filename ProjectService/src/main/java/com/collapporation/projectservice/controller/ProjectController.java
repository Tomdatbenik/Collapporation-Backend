package com.collapporation.projectservice.controller;

import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    //TODO Make it so other users can't get private details form other users.
    @GetMapping("/{userId}")
    public ResponseEntity<Project> getUser(@PathVariable("projectId") String projectId) {
        final Project user = projectService.getProject(projectId);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
