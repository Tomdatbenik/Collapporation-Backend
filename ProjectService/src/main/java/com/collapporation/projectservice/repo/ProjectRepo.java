package com.collapporation.projectservice.repo;

import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.ProjectStatus;
import com.collapporation.projectservice.models.dto.ProjectFeedDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepo extends JpaRepository<Project, String>
{
    List<ProjectFeedDTO> findAllByOrderByCreatedDesc(Pageable pageable);

    @Modifying
    @Query("UPDATE project p SET p.status = :newStatus where p.id = :id")
    void updateStatus(@Param("newStatus") ProjectStatus status, @Param("id") String id);
}
