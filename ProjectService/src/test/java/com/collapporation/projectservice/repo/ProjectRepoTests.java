package com.collapporation.projectservice.repo;

import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.ProjectStatus;
import com.collapporation.projectservice.repo.ProjectRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(scripts = "/test/project.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProjectRepoTests
{
    @Autowired
    private ProjectRepo projectRepo;

    @Test
    @Transactional
    public void updateStatusTest() {
        final String id = "0";
        final ProjectStatus projectStatus = ProjectStatus.PROJECT;

        projectRepo.updateStatus(id,projectStatus);
        final Project project = projectRepo.getOne(id);

        assertThat(project).isNotNull();
        assertThat(project.getId()).isEqualTo(id);
        assertThat(project.getStatus()).isEqualTo(projectStatus);
    }
}
