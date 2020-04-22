package com.collapporation.projectservice.repo;

import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.dto.ProjectFeedDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepo extends JpaRepository<Project, String> {
    List<ProjectFeedDTO> findAllByOrderByCreatedDesc(Pageable pageable);
}
