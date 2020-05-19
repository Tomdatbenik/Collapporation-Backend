package com.collapporation.likeservice.handler.method;

import com.collapporation.likeservice.event.ProjectUpdateStatusEvent;
import com.collapporation.likeservice.handler.HandlerMethod;
import com.collapporation.likeservice.repo.ProjectRepo;
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
