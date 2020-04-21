package com.collapperation.templateservice.repo;

import com.collapperation.templateservice.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, String> {
}
