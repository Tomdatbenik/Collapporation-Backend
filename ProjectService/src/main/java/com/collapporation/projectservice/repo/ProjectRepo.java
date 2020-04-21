package com.collapporation.projectservice.repo;

import com.collapporation.projectservice.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, String> {
}
