package com.collapporation.projectservice.handler.method;

import com.collapporation.projectservice.event.ProjectCreatedEvent;
import com.collapporation.projectservice.handler.method.CreateProjectEventHandleMethod;
import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.ProjectStatus;
import com.collapporation.projectservice.repo.ProjectRepo;
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
public class CreateProjectEventHandlerMethodTest
{
    @Autowired
    private ProjectRepo projectRepo;

    @Test
    void allArgsConstructorTest()
    {
        assertDoesNotThrow(() -> {
            new CreateProjectEventHandleMethod(projectRepo);
        });
    }

    @Test
    public void handlingTypeTest() {
        final CreateProjectEventHandleMethod createProjectEventHandleMethod = new CreateProjectEventHandleMethod(projectRepo);

        assertThat(createProjectEventHandleMethod).isNotNull();
        assertThat(createProjectEventHandleMethod.getHandlingType()).isEqualTo(ProjectCreatedEvent.class);
    }

    @Test
    @Transactional
    public void saveProjectTest()
    {
        final Project creatorProject = new Project();
        creatorProject.setId("3");
        creatorProject.setTitle("Test project");
        creatorProject.setSmallDescription("small description of project0");
        creatorProject.setDescription("very large markdown description of project0");
        creatorProject.setStatus(ProjectStatus.CONCEPT);
        creatorProject.setImg("https://picsum.photos/test/510/300?random");
        creatorProject.setOwnerId("0");

        final CreateProjectEventHandleMethod createProjectEventHandleMethod = new CreateProjectEventHandleMethod(projectRepo);

        createProjectEventHandleMethod.handle(new ProjectCreatedEvent(creatorProject));

        final Project project = projectRepo.findAll().get( projectRepo.findAll().size()-1);

        assertThat(project).isNotNull();
        assertThat(project.getId()).isEqualTo("3");
        assertThat(project.getTitle()).isEqualTo(creatorProject.getTitle());
        assertThat(project.getSmallDescription()).isEqualTo(creatorProject.getSmallDescription());
        assertThat(project.getDescription()).isEqualTo(creatorProject.getDescription());
        assertThat(project.getImg()).isEqualTo(creatorProject.getImg());
        assertThat(project.getOwnerId()).isEqualTo(creatorProject.getOwnerId());
        assertThat(project.getCreated()).isNotNull();

    }
}
