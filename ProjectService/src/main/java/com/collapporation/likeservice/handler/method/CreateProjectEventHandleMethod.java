package com.collapporation.likeservice.handler.method;

import com.collapporation.likeservice.event.ProjectCreatedEvent;
import com.collapporation.likeservice.handler.HandlerMethod;
import com.collapporation.likeservice.repo.ProjectRepo;
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
