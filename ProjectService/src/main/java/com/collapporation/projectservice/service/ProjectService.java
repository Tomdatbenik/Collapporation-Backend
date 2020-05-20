package com.collapporation.projectservice.service;

import com.collapporation.projectservice.event.ProjectCreatedEvent;
import com.collapporation.projectservice.event.ProjectUpdateEvent;
import com.collapporation.projectservice.event.ProjectUpdateStatusEvent;
import com.collapporation.projectservice.kafka.dispatcher.IDispatcher;
import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.ProjectStatus;
import com.collapporation.projectservice.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Value("${spring.kafka.topic}")
    String kafkaTopic;

    @Autowired
    public ProjectRepo projectRepo;

    @Autowired
    private IDispatcher dispatcher;

    public Project getProject(String id){
        return projectRepo.findById(id).orElse(null);
    }

    public void createProject(Project project)
    {
        dispatcher.dispatch(kafkaTopic, new ProjectCreatedEvent(project));
    }

    public void update(Project project)
    {
        dispatcher.dispatch(kafkaTopic, new ProjectUpdateEvent(project));
    }

    public void updateStatus(String id, ProjectStatus status)
    {
        dispatcher.dispatch(kafkaTopic, new ProjectUpdateStatusEvent(id,status));
    }
}
