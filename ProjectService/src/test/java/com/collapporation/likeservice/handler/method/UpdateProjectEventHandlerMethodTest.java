package com.collapporation.likeservice.handler.method;

import com.collapporation.likeservice.event.ProjectUpdateEvent;
import com.collapporation.likeservice.models.Project;
import com.collapporation.likeservice.models.ProjectStatus;
import com.collapporation.likeservice.repo.ProjectRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@Sql(scripts = {"/test/project.sql"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UpdateProjectEventHandlerMethodTest
{
    @Autowired
    private ProjectRepo projectRepo;

    @Test
    void AllArgsConstructorTest()
    {
        assertDoesNotThrow(() -> {
            new UpdateProjectEventHandleMethod(projectRepo);
        });
    }

    @Test
    public void handlingTypeTest() {
        final UpdateProjectEventHandleMethod updateProjectEventHandleMethod = new UpdateProjectEventHandleMethod(projectRepo);

        assertThat(updateProjectEventHandleMethod).isNotNull();
        assertThat(updateProjectEventHandleMethod.getHandlingType()).isEqualTo(ProjectUpdateEvent.class);
    }

    @Test
    @Transactional
    public void updateProjectTest()
    {
        final Project updateProject = new Project();
        updateProject.setId("0");
        updateProject.setTitle("Updated Project Title");
        updateProject.setSmallDescription("Updated small description of project0");
        updateProject.setDescription("Updated very large markdown description of project0");
        updateProject.setStatus(ProjectStatus.CONCEPT);
        updateProject.setImg("Updated https://picsum.photos/test/510/300?random");
        updateProject.setOwnerId("0");
        updateProject.setCreated(LocalDateTime.now());

        final UpdateProjectEventHandleMethod updateProjectEventHandleMethod = new UpdateProjectEventHandleMethod(projectRepo);

        updateProjectEventHandleMethod.handle(new ProjectUpdateEvent(updateProject));

        final Project project = projectRepo.getOne("0");

        assertThat(project).isNotNull();
        assertThat(project.getTitle()).isEqualTo(updateProject.getTitle());
        assertThat(project.getSmallDescription()).isEqualTo(updateProject.getSmallDescription());
        assertThat(project.getDescription()).isEqualTo(updateProject.getDescription());
        assertThat(project.getImg()).isEqualTo(updateProject.getImg());
        assertThat(project.getOwnerId()).isEqualTo(updateProject.getOwnerId());
        assertThat(project.getCreated()).isEqualTo(updateProject.getCreated());
    }
}
