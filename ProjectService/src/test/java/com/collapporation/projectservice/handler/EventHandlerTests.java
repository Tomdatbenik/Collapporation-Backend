package com.collapporation.projectservice.handler;


import com.collapporation.projectservice.event.Event;
import com.collapporation.projectservice.event.ProjectCreatedEvent;
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
public class EventHandlerTests
{
    @Autowired
    private EventHandler eventHandler;

    @Autowired
    private ProjectRepo projectRepo;

    @Test
    @Transactional
    public void processEventTest(){
        final Project creatorProject = new Project();
        creatorProject.setId("0");
        creatorProject.setTitle("Procces event test project0");
        creatorProject.setSmallDescription("small description of project0");
        creatorProject.setDescription("very large markdown description of project0");
        creatorProject.setStatus(ProjectStatus.CONCEPT);
        creatorProject.setImg("https://picsum.photos/510/300?random");
        creatorProject.setOwnerId("0");
        creatorProject.setCreated(LocalDateTime.now());

        eventHandler.processEvent((new ProjectCreatedEvent(creatorProject)));
        final Project project = projectRepo.getOne(creatorProject.getId());

        assertThat(project).isNotNull();
        assertThat(project.getId()).isEqualTo(creatorProject.getId());
        assertThat(project.getTitle()).isEqualTo(creatorProject.getTitle());
        assertThat(project.getSmallDescription()).isEqualTo(creatorProject.getSmallDescription());
        assertThat(project.getDescription()).isEqualTo(creatorProject.getDescription());
        assertThat(project.getImg()).isEqualTo(creatorProject.getImg());
        assertThat(project.getOwnerId()).isEqualTo(creatorProject.getOwnerId());
        assertThat(project.getCreated()).isEqualTo(creatorProject.getCreated());
    }

    //Test class created for process Unkown Event Test
    private class UnknownEvent extends Event
    {

    }

    @Test
    public void processUnknownEventTest() {
        assertDoesNotThrow(() -> eventHandler.processEvent(new UnknownEvent()));
    }
}
