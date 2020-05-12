package com.collapporation.projectservice.event;

import com.collapporation.projectservice.models.Project;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProjectCreatedEventTest
{
    @Test
    public void allArgsConstructorTest()
    {
        final ProjectCreatedEvent projectCreatedEvent = new ProjectCreatedEvent(new Project());

        assertThat(projectCreatedEvent).isNotNull();
        assertThat(projectCreatedEvent.getCreator()).isEqualTo("project-service");
    }

    @Test
    public void equalsTest()
    {
        final ProjectCreatedEvent projectCreatedEventA = new ProjectCreatedEvent();
        final ProjectCreatedEvent projectCreatedEventB = new ProjectCreatedEvent();

        assertThat(projectCreatedEventA).isEqualTo(projectCreatedEventB);
    }

    @Test
    public void notEqualTest()
    {
        final ProjectCreatedEvent projectCreatedEventA = new ProjectCreatedEvent();
        final ProjectCreatedEvent projectCreatedEventB = new ProjectCreatedEvent();

        projectCreatedEventA.setProject(new Project());

        assertThat(projectCreatedEventA).isNotEqualTo(projectCreatedEventB);
    }
}
