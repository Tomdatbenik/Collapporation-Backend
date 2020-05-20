package com.collapporation.projectservice.DTO;

import com.collapporation.projectservice.models.Project;
import com.collapporation.projectservice.models.ProjectStatus;
import com.collapporation.projectservice.models.dto.ProjectFeedDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(scripts = "/test/project.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProjectFeedDTOTest {

    LocalDateTime localTime = LocalDateTime.now();

    protected byte[] byteArray = new byte[] {1};

    private Project project = new Project("testproject", "testtitle", "testSmalldescription", "testDescription", ProjectStatus.CONCEPT, byteArray, "testOwnerid", localTime);

    private ProjectFeedDTO projectFeedDTO = new ProjectFeedDTO(project);

    @Test
    public void getId(){
        String projectId = projectFeedDTO.getId();

        String expected = "testproject";

        assertThat(projectId).isEqualTo(expected);
    }

    @Test
    public void setId(){
        projectFeedDTO.setId("newTestProjectId");

        String projectId = projectFeedDTO.getId();

        String expected = "newTestProjectId";

        assertThat(projectId).isEqualTo(expected);
    }

    @Test
    public void getTitle(){
        String projectTitle = projectFeedDTO.getTitle();

        String expected = "testtitle";

        assertThat(projectTitle).isEqualTo(expected);
    }

    @Test
    public void setTitle(){
        projectFeedDTO.setTitle("newTestTitle");

        String projectTitle = projectFeedDTO.getTitle();

        String expected = "newTestTitle";

        assertThat(projectTitle).isEqualTo(expected);
    }

    @Test
    public void getSmallDescription(){
        String projectSmallDescription = projectFeedDTO.getSmallDescription();

        String expected = "testSmalldescription";

        assertThat(projectSmallDescription).isEqualTo(expected);
    }

    @Test
    public void setSmallDescription(){
        projectFeedDTO.setSmallDescription("newTestSmallDescription");

        String projectSmallDescription = projectFeedDTO.getSmallDescription();

        String expected = "newTestSmallDescription";

        assertThat(projectSmallDescription).isEqualTo(expected);
    }

    @Test
    public void getStatus(){
        ProjectStatus projectStatus = projectFeedDTO.getStatus();

        ProjectStatus expected = ProjectStatus.CONCEPT;

        assertThat(projectStatus).isEqualTo(expected);
    }

    @Test
    public void setStatus(){
        projectFeedDTO.setStatus(ProjectStatus.PROJECT);

        ProjectStatus projectStatus = projectFeedDTO.getStatus();

        ProjectStatus expected = ProjectStatus.PROJECT;

        assertThat(projectStatus).isEqualTo(expected);
    }

    @Test
    public void getImg(){
        byte[] projectImg = projectFeedDTO.getImg();

        byte[] expected = byteArray;

        assertThat(projectImg).isEqualTo(expected);
    }

    @Test
    public void setImg(){
        projectFeedDTO.setImg(new byte[] {2});

        byte[] projectImg = projectFeedDTO.getImg();

        byte[] expected = new byte[] {2};

        assertThat(projectImg).isEqualTo(expected);
    }

    @Test
    public void getCreated(){
        LocalDateTime projectCreated = projectFeedDTO.getCreated();

        LocalDateTime expected = localTime;

        assertThat(projectCreated).isEqualTo(expected);
    }

    @Test
    public void setCreated(){
        LocalDateTime newLocalDateTime = LocalDateTime.now();

        projectFeedDTO.setCreated(newLocalDateTime);

        LocalDateTime projectCreated = projectFeedDTO.getCreated();

        LocalDateTime expected = newLocalDateTime;

        assertThat(projectCreated).isEqualTo(expected);
    }

    //TODO make tests for tags, likes and follow(can't be done right now because getters don't exist and might not be needed)
}
