package com.collapporation.projectservice.handler.method;

import com.collapporation.projectservice.event.ProjectCreatedEvent;
import com.collapporation.projectservice.handler.HandlerMethod;
import com.collapporation.projectservice.repo.ProjectRepo;
import org.springframework.stereotype.Component;

@Component
public class CreateProjectEventHandleMethod extends HandlerMethod<ProjectCreatedEvent>
{
    private final ProjectRepo projectRepo;

    public CreateProjectEventHandleMethod(ProjectRepo projectRepo)
    {
        super(ProjectCreatedEvent.class);
        this.projectRepo = projectRepo;
    }

    @Override
    public void handle(ProjectCreatedEvent event)
    {
        projectRepo.save(event.getProject());
    }
}
