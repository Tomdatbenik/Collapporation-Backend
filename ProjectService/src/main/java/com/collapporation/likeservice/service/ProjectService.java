package com.collapporation.likeservice.service;

import com.collapporation.likeservice.event.ProjectCreatedEvent;
import com.collapporation.likeservice.event.ProjectUpdateEvent;
import com.collapporation.likeservice.event.ProjectUpdateStatusEvent;
import com.collapporation.likeservice.kafka.dispatcher.IDispatcher;
import com.collapporation.likeservice.models.Project;
import com.collapporation.likeservice.models.ProjectStatus;
import com.collapporation.likeservice.repo.ProjectRepo;
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
