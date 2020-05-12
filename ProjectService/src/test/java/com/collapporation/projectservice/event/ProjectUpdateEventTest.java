package com.collapporation.projectservice.event;

import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.ProjectStatus;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProjectUpdateEventTest
{
    @Test
    public void allArgsConstructorTest()
    {
        final ProjectUpdateEvent projectUpdateEvent = new ProjectUpdateEvent(new Project());
        assertThat(projectUpdateEvent).isNotNull();
        assertThat(projectUpdateEvent.getCreator()).isEqualTo("project-service");
    }

    @Test
    public void equalsTest()
    {
        final ProjectUpdateEvent projectUpdateEventA = new ProjectUpdateEvent();
        final ProjectUpdateEvent projectUpdateEventB = new ProjectUpdateEvent();

        assertThat(projectUpdateEventA).isEqualTo(projectUpdateEventB);
    }

    @Test
    public void notEqualTest()
    {
        final ProjectUpdateEvent projectUpdateEventA = new ProjectUpdateEvent();
        final ProjectUpdateEvent projectUpdateEventB = new ProjectUpdateEvent();

        projectUpdateEventB.setProject(new Project());

        assertThat(projectUpdateEventA).isNotEqualTo(projectUpdateEventB);
    }
}
