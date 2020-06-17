package com.collapporation.projectservice.handler.method;

import com.collapporation.projectservice.event.ProjectUpdateEvent;
import com.collapporation.projectservice.handler.HandlerMethod;
import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.repo.ProjectRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class UpdateProjectEventHandleMethod extends HandlerMethod<ProjectUpdateEvent> {

    private ProjectRepo projectRepo;

    public UpdateProjectEventHandleMethod(ProjectRepo projectRepo) {
        super(ProjectUpdateEvent.class);
        this.projectRepo = projectRepo;
    }

    @Override
    public void handle(ProjectUpdateEvent event) {

        Project project = projectRepo.findById(event.getProject().getId()).orElse(null);
        if(project != null)
        {
            project.setTitle(event.getProject().getTitle());
            project.setDescription(event.getProject().getDescription());
            project.setSmallDescription(event.getProject().getSmallDescription());
            project.setImg(event.getProject().getImg());


            log.info("Updating project: " + project.getTitle());
            projectRepo.save(project);
        }

        log.info("Updating project no project found to update");

    }
}
