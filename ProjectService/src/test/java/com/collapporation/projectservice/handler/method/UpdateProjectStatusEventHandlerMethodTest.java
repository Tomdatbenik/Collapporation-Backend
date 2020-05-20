package com.collapporation.projectservice.handler.method;

import com.collapporation.projectservice.event.ProjectUpdateStatusEvent;
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
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@Sql(scripts = {"/test/project.sql"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UpdateProjectStatusEventHandlerMethodTest
{
    @Autowired
    private ProjectRepo projectRepo;

    @Test
    void allArgsConstructorTest()
    {
        assertDoesNotThrow(() -> {
            new UpdateStatusProjectEventHandleMethod(projectRepo);
        });
    }

    @Test
    public void handlingTypeTest() {
        final UpdateStatusProjectEventHandleMethod updateStatusProjectEventHandleMethod = new UpdateStatusProjectEventHandleMethod(projectRepo);

        assertThat(updateStatusProjectEventHandleMethod).isNotNull();
        assertThat(updateStatusProjectEventHandleMethod.getHandlingType()).isEqualTo(ProjectUpdateStatusEvent.class);
    }

    @Test
    @Transactional
    public void updateProjectStatusTest()
    {
        final UpdateStatusProjectEventHandleMethod updateStatusProjectEventHandleMethod = new UpdateStatusProjectEventHandleMethod(projectRepo);

        updateStatusProjectEventHandleMethod.handle(new ProjectUpdateStatusEvent("0",ProjectStatus.PROJECT));

        final Project project = projectRepo.getOne("0");

        assertThat(project).isNotNull();
        assertThat(project.getStatus()).isEqualTo(ProjectStatus.PROJECT);
    }
}
