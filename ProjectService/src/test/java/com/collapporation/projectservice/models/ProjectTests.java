package com.collapporation.projectservice.models;

import com.collapporation.projectservice.models.dto.ProjectDTO;
import com.collapporation.projectservice.models.dto.ProjectFeedDTO;
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
    public void projectDTOContructorTest()
    {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId( "0");
        projectDTO.setTitle("project0");
        projectDTO.setStatus( ProjectStatus.CONCEPT);
        projectDTO.setSmallDescription("Small description of project0.");
        projectDTO.setImg("Cool image");
        projectDTO.setOwner("0");
        projectDTO.setCreated(LocalDateTime.now());


        final Project project = new Project(projectDTO);

        assertThat(project).isNotNull();
        assertThat(project.getId()).isEqualTo(projectDTO.getId());
        assertThat(project.getTitle()).isEqualTo(projectDTO.getTitle());
        assertThat(project.getStatus()).isEqualTo(projectDTO.getStatus());
        assertThat(project.getSmallDescription()).isEqualTo(projectDTO.getSmallDescription());
        assertThat(project.getDescription()).isEqualTo("");
        assertThat(project.getImg()).isEqualTo(projectDTO.getImg());
        assertThat(project.getCreated()).isEqualTo(projectDTO.getCreated());
        assertThat(project.getOwnerId()).isEqualTo(projectDTO.getOwner());
    }

    @Test
    public void projectFeedDTOContructorTest()
    {
        ProjectFeedDTO projectDTO = new ProjectFeedDTO();
        projectDTO.setId( "0");
        projectDTO.setTitle("project0");
        projectDTO.setStatus( ProjectStatus.CONCEPT);
        projectDTO.setSmallDescription("Small description of project0.");
        projectDTO.setImg("Cool image");
        projectDTO.setOwner("0");
        projectDTO.setCreated(LocalDateTime.now());


        final Project project = new Project(projectDTO);

        assertThat(project).isNotNull();
        assertThat(project.getId()).isEqualTo(projectDTO.getId());
        assertThat(project.getTitle()).isEqualTo(projectDTO.getTitle());
        assertThat(project.getStatus()).isEqualTo(projectDTO.getStatus());
        assertThat(project.getSmallDescription()).isEqualTo(projectDTO.getSmallDescription());
        assertThat(project.getDescription()).isEqualTo("");
        assertThat(project.getImg()).isEqualTo(projectDTO.getImg());
        assertThat(project.getCreated()).isEqualTo(projectDTO.getCreated());
        assertThat(project.getOwnerId()).isEqualTo(projectDTO.getOwner());
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
