package com.collapporation.projectservice.handler.method;

import com.collapporation.projectservice.event.ProjectCreatedEvent;
import com.collapporation.projectservice.event.ProjectDeleteEvent;
import com.collapporation.projectservice.handler.HandlerMethod;
import com.collapporation.projectservice.repo.ProjectRepo;
import org.springframework.stereotype.Component;

@Component
public class DeleteProjectEventHandleMethod extends HandlerMethod<ProjectDeleteEvent>
{
    private final ProjectRepo projectRepo;

    public DeleteProjectEventHandleMethod(ProjectRepo projectRepo)
    {
        super(ProjectDeleteEvent.class);
        this.projectRepo = projectRepo;
    }

    @Override
    public void handle(ProjectDeleteEvent event)
    {
        projectRepo.delete(event.getProject());
    }
}
