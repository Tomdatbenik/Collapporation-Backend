package com.collapporation.projectservice.handler.method;

import com.collapporation.projectservice.event.ProjectUpdateStatusEvent;
import com.collapporation.projectservice.handler.HandlerMethod;
import com.collapporation.projectservice.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateStatusProjectEventHandleMethod extends HandlerMethod<ProjectUpdateStatusEvent> {
    private ProjectRepo projectRepo;

    protected UpdateStatusProjectEventHandleMethod(ProjectRepo repo) {
        super(ProjectUpdateStatusEvent.class);
        projectRepo = repo;
    }

    @Override
    public void handle(ProjectUpdateStatusEvent event) {
        projectRepo.updateStatus(event.getProjectId(), event.getStatus());
    }
}
