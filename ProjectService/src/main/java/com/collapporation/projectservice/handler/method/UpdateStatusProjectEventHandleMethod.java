package com.collapporation.projectservice.handler.method;

import com.collapporation.projectservice.event.ProjectUpdateStatusEvent;
import com.collapporation.projectservice.handler.HandlerMethod;
import com.collapporation.projectservice.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateStatusProjectEventHandleMethod extends HandlerMethod<ProjectUpdateStatusEvent> {
    protected UpdateStatusProjectEventHandleMethod() {
        super(ProjectUpdateStatusEvent.class);
    }

    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public void handle(ProjectUpdateStatusEvent event) {
        projectRepo.updateStatus(event.getProjectId(), event.getStatus());
    }
}
