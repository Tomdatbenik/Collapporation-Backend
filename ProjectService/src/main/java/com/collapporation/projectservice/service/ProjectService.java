package com.collapporation.projectservice.service;

import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.repo.ProjectRepo;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    public ProjectRepo projectRepo;

    public Project getProject(String id){
        return projectRepo.findById(id).orElse(null);
    }
}