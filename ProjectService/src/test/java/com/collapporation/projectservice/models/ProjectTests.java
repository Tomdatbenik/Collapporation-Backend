package com.collapporation.projectservice.models;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.assertThat;

public class ProjectTests
{
    @Test
    public void noArgsContructorTest()
    {
        final Project project = new Project();

        assertThat(project).isNotNull();
        assertThat(project.getId()).isNull();
        assertThat(project.getTitle()).isNull();
        assertThat(project.getStatus()).isNull();
        assertThat(project.getSmallDescription()).isNull();
        assertThat(project.getDescription()).isNull();
        assertThat(project.getImg()).isNull();
        assertThat(project.getCreated()).isNull();
        assertThat(project.getOwnerId()).isNull();
    }

    @Test
    public void allArgsContructorTest()
    {
        final String id = "0";
        final String title = "project0";
        final ProjectStatus status = ProjectStatus.CONCEPT;
        final String smalldescription = "Small description of project0.";
        final String description = "Large markdown description of project0";
        final String image = "cool image";
        final LocalDateTime localDateTime = LocalDateTime.now();
        final String ownerId = "0";
        final Project project = new Project(id, title, smalldescription, description, status, image, ownerId, localDateTime);

        assertThat(project).isNotNull();
        assertThat(project.getId()).isEqualTo(id);
        assertThat(project.getTitle()).isEqualTo(title);
        assertThat(project.getStatus()).isEqualTo(status);
        assertThat(project.getSmallDescription()).isEqualTo(smalldescription);
        assertThat(project.getDescription()).isEqualTo(description);
        assertThat(project.getImg()).isEqualTo(image);
        assertThat(project.getCreated()).isEqualTo(localDateTime);
        assertThat(project.getOwnerId()).isEqualTo(ownerId);
    }

    @Test
    public void equalsTest()
    {
        final Project projectA = new Project();
        final Project projectB = new Project();

        assertThat(projectA).isEqualTo(projectB);
    }

    @Test
    public void notEqualTest() {
        final Project projectA = new Project();
        final Project projectB = new Project();

        projectA.setTitle("different title than projectB");

        assertThat(projectA).isNotEqualTo(projectB);
    }
}
