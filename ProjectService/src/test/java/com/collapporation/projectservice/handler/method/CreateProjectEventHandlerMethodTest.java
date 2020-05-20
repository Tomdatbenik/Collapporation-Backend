package com.collapporation.projectservice.handler.method;

import com.collapporation.projectservice.event.ProjectCreatedEvent;
import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.ProjectStatus;
import com.collapporation.projectservice.repo.ProjectRepo;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import javax.transaction.Transactional;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.mock;

@SpringBootTest
@Sql(scripts = {"/test/project.sql"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class CreateProjectEventHandlerMethodTest
{
    @Autowired
    private ProjectRepo projectRepo;

    @Mock
    public Blob blob;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

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
        creatorProject.setTitle("Test project");
        creatorProject.setSmallDescription("small description of project0");
        creatorProject.setDescription("very large markdown description of project0");
        creatorProject.setStatus(ProjectStatus.CONCEPT);
        creatorProject.setImg(new byte[] {1});
        creatorProject.setOwnerId("0");
        creatorProject.setCreated(LocalDateTime.now());

        final CreateProjectEventHandleMethod createProjectEventHandleMethod = new CreateProjectEventHandleMethod(projectRepo);

        createProjectEventHandleMethod.handle(new ProjectCreatedEvent(creatorProject));

        final Project project = projectRepo.findAll().get( projectRepo.findAll().size()-1);

        assertThat(project).isNotNull();
        assertThat(project.getTitle()).isEqualTo(creatorProject.getTitle());
        assertThat(project.getSmallDescription()).isEqualTo(creatorProject.getSmallDescription());
        assertThat(project.getDescription()).isEqualTo(creatorProject.getDescription());
        System.out.println("before image");
        assertThat(project.getImg()).isEqualTo(creatorProject.getImg());
        assertThat(project.getOwnerId()).isEqualTo(creatorProject.getOwnerId());
        assertThat(project.getCreated()).isEqualTo(creatorProject.getCreated());

    }
}
