package com.collapporation.projectservice.handler.method;

import com.collapporation.projectservice.event.ProjectUpdateEvent;
import com.collapporation.projectservice.event.ProjectUpdateStatusEvent;
import com.collapporation.projectservice.handler.HandlerMethod;
import com.collapporation.projectservice.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
