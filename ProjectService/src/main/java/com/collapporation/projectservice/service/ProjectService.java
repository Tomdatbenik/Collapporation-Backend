package com.collapporation.projectservice.service;

import com.collapporation.projectservice.event.ProjectCreatedEvent;
import com.collapporation.projectservice.event.ProjectDeleteEvent;
import com.collapporation.projectservice.event.ProjectUpdateEvent;
import com.collapporation.projectservice.event.ProjectUpdateStatusEvent;
import com.collapporation.projectservice.kafka.dispatcher.IDispatcher;
import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.ProjectStatus;
import com.collapporation.projectservice.repo.ProjectRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProjectService {

    @Value("${spring.kafka.topic}")
    String kafkaTopic;

    @Autowired
    public ProjectRepo projectRepo;

    @Autowired
    private IDispatcher dispatcher;

    public Project getProject(String id) {
        log.info("Repo returning project with id: " + id);
        return projectRepo.findById(id).orElse(null);
    }

    public void createProject(Project project) {
        log.info("Sending project into kafka: " + kafkaTopic);
        dispatcher.dispatch(kafkaTopic, new ProjectCreatedEvent(project));
        log.info("Project send");
    }

    public void update(Project project) {
        log.info("Updating project, send project into kafka: " + kafkaTopic);
        dispatcher.dispatch(kafkaTopic, new ProjectUpdateEvent(project));
    }

    public void updateStatus(String id, ProjectStatus status) {
        log.info("Updating status, send project into kafka: " + kafkaTopic);
        dispatcher.dispatch(kafkaTopic, new ProjectUpdateStatusEvent(id, status));
    }

    public void deleteProject(Project project) {
        dispatcher.dispatch(kafkaTopic, new ProjectDeleteEvent(project));
    }
}
