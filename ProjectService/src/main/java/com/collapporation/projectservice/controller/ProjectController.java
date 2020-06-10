package com.collapporation.projectservice.controller;

import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.ProjectStatus;
import com.collapporation.projectservice.models.dto.ErrorDto;
import com.collapporation.projectservice.models.dto.ProjectDTO;
import com.collapporation.projectservice.service.ProjectService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private final ProjectService projectService;

    @Autowired
    private final RestTemplate restTemplate;

    private final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable("projectId") String projectId) {

        log.info("Getting project with id: " + projectId);
        final Project project = projectService.getProject(projectId);
        ProjectDTO projectDTO = new ProjectDTO(project);

        if(project == null){
            log.warn("Project: is null, returning");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            try{

                log.info("Getting owner by id: " + project.getOwnerId() );
                projectDTO.setOwner(restTemplate.getForObject("http://user-service/user/" + project.getOwnerId(), String.class));
                log.info("Received owner by id: " + project.getOwnerId() );
                log.info("Getting likes by id: " + project.getId() );
                projectDTO.setLikes(restTemplate.getForObject("http://like-service/like/count?object_id=" + project.getId(), String.class));
                log.info("Received likes by id: " + project.getId() );
            }
            catch (Exception ex) {
                log.error(ex.getMessage());
                projectDTO.setLikes(null);
                projectDTO.setOwner("{ name: 'no user could be found' }");
            }

            //TODO fill project with tags links comments etc.
        }

        log.info("Returning: " + projectDTO );
        return new ResponseEntity(projectDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity createProject(@RequestBody Project project)
    {
        log.info("Validating project");
        List<ErrorDto> errors = validateProject(project);

        if(errors == null)
        {
            log.info("Creating random UUiD for project: " + project.getTitle());
            project.setId(UUID.randomUUID().toString().replace("-", ""));

            log.info("Creating project");
            projectService.createProject(project);

            log.info("Returning project with id: " + project.getId());
            return new ResponseEntity(project,HttpStatus.OK);
        }
        else {
            log.info("Errors with validating project: " + errors.size());
            log.warn("Returning errors");
            return new ResponseEntity(errors ,HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PutMapping("/update/status")
    public ResponseEntity updateStatus(@PathVariable("projectId") String projectId, @PathVariable("status") ProjectStatus status)
    {
        log.info("updating project status to: " + status);
        projectService.updateStatus(projectId,status);

        log.info("returning OK");
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateProject(@RequestBody Project project)
    {
        log.info("Validating project");
        List<ErrorDto> errors = validateProject(project);


        if(errors == null)
        {
            log.info("Updating project");
            projectService.update(project);

            log.info("Returning OK");
            return new ResponseEntity(HttpStatus.OK);
        }
        else {
            log.info("Errors with validating project: " + errors.size());
            log.warn("Returning errors");
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
