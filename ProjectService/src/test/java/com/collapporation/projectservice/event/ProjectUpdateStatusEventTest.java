package com.collapporation.projectservice.event;

import com.collapporation.projectservice.event.ProjectUpdateStatusEvent;
import com.collapporation.projectservice.models.ProjectStatus;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
public class ProjectUpdateStatusEventTest
{
    @Test
    public void allArgsConstructorTest()
    {
        final ProjectUpdateStatusEvent projectUpdateStatusEvent = new ProjectUpdateStatusEvent("0", ProjectStatus.CONCEPT);
        assertThat(projectUpdateStatusEvent).isNotNull();
        assertThat(projectUpdateStatusEvent.getCreator()).isEqualTo("project-service");
    }

    @Test
    public void equalsTest()
    {
        final ProjectUpdateStatusEvent projectUpdateStatusEventA = new ProjectUpdateStatusEvent();
        final ProjectUpdateStatusEvent projectUpdateStatusEventB = new ProjectUpdateStatusEvent();

        assertThat(projectUpdateStatusEventA).isEqualTo(projectUpdateStatusEventB);
    }

    @Test
    public void notEqualTest()
    {
        final ProjectUpdateStatusEvent projectUpdateStatusEventA = new ProjectUpdateStatusEvent();
        final ProjectUpdateStatusEvent projectUpdateStatusEventB = new ProjectUpdateStatusEvent();

        projectUpdateStatusEventB.setProjectId("0");

        assertThat(projectUpdateStatusEventA).isNotEqualTo(projectUpdateStatusEventB);
    }
}
