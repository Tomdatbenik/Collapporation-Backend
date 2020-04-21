package com.collapperation.templateservice.service;

import com.collapperation.templateservice.models.Project;
import com.collapperation.templateservice.repo.ProjectRepo;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    public ProjectRepo projectRepo;

    public Project getProject(String id){
        return projectRepo.findById(id).orElse(null);
    }
}
