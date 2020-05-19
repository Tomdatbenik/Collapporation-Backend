package com.collapporation.likeservice.service;

import com.collapporation.likeservice.models.dto.ProjectFeedDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(scripts = "/test/project.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class FeedServiceTest {
    @Autowired
    public FeedService feedService;

    //TODO mock userservice to make test run without userservice running
    @Test
    public void getFeedProjectsCorrectly(){
        final List<ProjectFeedDTO> projectFeed = feedService.getProjectFeed(0, 10);

        int expectedAmount = 2;

        assertThat(projectFeed.size()).isEqualTo(expectedAmount);
    }

    @Test
    public void getFeedProjectsIncorrectly(){
        final List<ProjectFeedDTO> projectFeed = feedService.getProjectFeed(1, 10);

        int expectedAmount = 0;

        assertThat(projectFeed.size()).isEqualTo(expectedAmount);
    }
}