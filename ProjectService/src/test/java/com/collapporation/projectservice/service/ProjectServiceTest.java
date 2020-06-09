package com.collapporation.projectservice.service;

import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(scripts = "/test/project.sql")
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProjectServiceTest
{
    @Autowired
    private ProjectService projectService;

    @Test
    public void getProjectTest()
    {
        final Project project = projectService.getProject("0");
        assertThat(project).isNotNull();
    }

    public void getNullTest()
    {
        final Project project = projectService.getProject("not an id");
        assertThat(project).isNull();
    }
}
