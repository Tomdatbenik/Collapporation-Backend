package com.collapporation.likeservice.handler.method;

import com.collapporation.likeservice.event.ProjectUpdateEvent;
import com.collapporation.likeservice.handler.HandlerMethod;
import com.collapporation.likeservice.repo.ProjectRepo;
import org.springframework.stereotype.Component;

@Component
public class UpdateProjectEventHandleMethod extends HandlerMethod<ProjectUpdateEvent> {

    private ProjectRepo projectRepo;

    public UpdateProjectEventHandleMethod(ProjectRepo projectRepo) {
        super(ProjectUpdateEvent.class);
        this.projectRepo = projectRepo;
    }

    @Override
    public void handle(ProjectUpdateEvent event) {
        projectRepo.save(event.getProject());
    }
}
