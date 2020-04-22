package com.collapporation.projectservice.handler.method;

import com.collapporation.projectservice.event.ProjectUpdateEvent;
import com.collapporation.projectservice.handler.HandlerMethod;
import com.collapporation.projectservice.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateProjectEventHandleMethod extends HandlerMethod<ProjectUpdateEvent> {
    protected UpdateProjectEventHandleMethod() {
        super(ProjectUpdateEvent.class);
    }

    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public void handle(ProjectUpdateEvent event) {
        projectRepo.updateStatus(event.getProjectId(), event.getStatus());
    }
}
