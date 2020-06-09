package com.collapporation.projectservice.controller;

import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.ProjectStatus;
import com.collapporation.projectservice.models.dto.ErrorDto;
import com.collapporation.projectservice.models.dto.ProjectDTO;
import com.collapporation.projectservice.service.ProjectService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@AllArgsConstructor
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private final ProjectService projectService;

    private final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable("projectId") String projectId) {
        final Project project = projectService.getProject(projectId);
        ProjectDTO projectDTO = new ProjectDTO(project);

        if(project == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            //TODO fill project with tags links comments etc.
        }

        return new ResponseEntity(projectDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity createProject(@RequestBody Project project)
    {
        List<ErrorDto> errors = validateProject(project);

        if(errors == null)
        {
            UUID uuid = new UUID();
            project.setId(uuid.randomUUID().toString());
            projectService.createProject(project);
            return new ResponseEntity(project,HttpStatus.OK);
        }
        else {
            return new ResponseEntity(errors ,HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PutMapping("/update/status")
    public ResponseEntity updateStatus(@PathVariable("projectId") String projectId, @PathVariable("status") ProjectStatus status)
    {
        projectService.updateStatus(projectId,status);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateProject(@RequestBody Project project)
    {
        List<ErrorDto> errors = validateProject(project);

        if(errors == null)
        {
            projectService.update(project);
            return new ResponseEntity(HttpStatus.OK);
        }
        else {
            return new ResponseEntity(errors ,HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    private List<ErrorDto> validateProject(Project project)
    {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Project>> errors = validator.validate(project);

        if(errors.size() == 0)
        {
            return null;
        }
        else {
            List<ErrorDto> errorList = new ArrayList<>();
            errors.stream().forEach(e->{
                errorList.add(new ErrorDto(e.getPropertyPath() + " " +  e.getMessage(), e.getPropertyPath().toString()));
            });

            return errorList;
        }
    }
}
