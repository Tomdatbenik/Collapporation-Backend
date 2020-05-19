package com.collapporation.likeservice.repo;

import com.collapporation.likeservice.models.Project;
import com.collapporation.likeservice.models.ProjectStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProjectRepo extends JpaRepository<Project, String> {

    List<Project> findAllByOrderByCreatedDesc(Pageable pageable);

    @Modifying
    @Query("UPDATE project p SET p.status = :newStatus WHERE p.id = :id")
    void updateStatus(@Param("id") String id, @Param("newStatus") ProjectStatus status);

    @Modifying
    @Query("UPDATE project p SET p = :newProject WHERE p.id = :projectId")
    void update(@Param("projectId") String id, @Param("newProject") Project project);
}
