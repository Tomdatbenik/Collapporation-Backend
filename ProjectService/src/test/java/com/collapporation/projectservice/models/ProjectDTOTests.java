package com.collapporation.projectservice.models;

import com.collapporation.projectservice.models.dto.ProjectDTO;
import com.collapporation.projectservice.models.dto.ProjectFeedDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ProjectDTOTests
{
    @Test
    public void noArgsContructorTest()
    {
        final ProjectDTO project = new ProjectDTO();

        assertThat(project).isNotNull();
        assertThat(project.getId()).isNull();
        assertThat(project.getTitle()).isNull();
        assertThat(project.getStatus()).isNull();
        assertThat(project.getSmallDescription()).isNull();
        assertThat(project.getImg()).isNull();
        assertThat(project.getCreated()).isNull();
        assertThat(project.getOwner()).isNull();
    }

    @Test
    public void projectContructorTest()
    {
        Project project = new Project();
        project.setId( "0");
        project.setTitle("project0");
        project.setStatus( ProjectStatus.CONCEPT);
        project.setSmallDescription("Small description of project0.");
        project.setImg("Cool image");
        project.setOwnerId("0");
        project.setCreated(LocalDateTime.now());


        final ProjectDTO projectDTO = new ProjectDTO(project);

        assertThat(projectDTO).isNotNull();
        assertThat(projectDTO.getId()).isEqualTo(project.getId());
        assertThat(projectDTO.getTitle()).isEqualTo(project.getTitle());
        assertThat(projectDTO.getStatus()).isEqualTo(project.getStatus());
        assertThat(projectDTO.getSmallDescription()).isEqualTo(project.getSmallDescription());
        assertThat(projectDTO.getImg()).isEqualTo(project.getImg());
        assertThat(projectDTO.getCreated()).isEqualTo(project.getCreated());
        assertThat(projectDTO.getOwner()).isEqualTo(project.getOwnerId());
    }

    @Test
    public void equalsEmptyNotEqualTest()
    {
        final ProjectDTO projectA = new ProjectDTO();
        final ProjectDTO projectB = new ProjectDTO();

        assertThat(projectA).isNotEqualTo(projectB);
    }

    @Test
    public void notEqualTest() {
        final ProjectDTO projectA = new ProjectDTO();
        final ProjectDTO projectB = new ProjectDTO();

        projectA.setTitle("different title than projectB");

        assertThat(projectA).isNotEqualTo(projectB);
    }
}
