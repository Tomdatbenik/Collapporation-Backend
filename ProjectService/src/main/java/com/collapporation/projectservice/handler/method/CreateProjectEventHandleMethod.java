package com.collapporation.projectservice.handler.method;

import com.collapporation.projectservice.event.ProjectCreatedEvent;
import com.collapporation.projectservice.handler.HandlerMethod;
import com.collapporation.projectservice.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateProjectEventHandleMethod extends HandlerMethod<ProjectCreatedEvent> {
    protected CreateProjectEventHandleMethod() {
        super(ProjectCreatedEvent.class);
    }

    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public void handle(ProjectCreatedEvent event) {
        projectRepo.save(event.getProject());
    }
}
