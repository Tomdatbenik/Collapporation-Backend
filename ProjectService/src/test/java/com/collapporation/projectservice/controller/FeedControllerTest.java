package com.collapporation.projectservice.controller;

import com.collapporation.projectservice.service.FeedService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = "/test/project.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class FeedControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Autowired
    public FeedService feedService;

    @Test
    public void getSingleFeedCorrectly() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/projectfeed/all?page=0&size=1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200)).andReturn();

        String expectedResult = "[{\"id\":\"0\",\"title\":\"project0\",\"smallDescription\":\"small description of project0\",\"status\":\"CONCEPT\",\"img\":\"https://picsum.photos/510/300?random\",\"owner\":{\"id\":\"0\",\"username\":\"test\",\"firstName\":\"test\",\"lastName\":\"test\",\"bio\":\"test\",\"picture\":\"test\"},\"created\":null,\"tags\":[],\"likes\":2,\"follow\":true}]";

        assertThat(result.getResponse().getContentAsString()).isEqualTo(expectedResult);
    }

    @Test
    public void getMultipleFeedCorrectly() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/projectfeed/all?page=0&size=10")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200)).andReturn();

        String expectedResult = "[{\"id\":\"1\",\"title\":\"project1\",\"smallDescription\":\"small description of project1\",\"status\":\"PROJECT\",\"img\":\"https://picsum.photos/510/300?random\",\"owner\":{\"id\":\"0\",\"username\":\"test\",\"firstName\":\"test\",\"lastName\":\"test\",\"bio\":\"test\",\"picture\":\"test\"},\"created\":null,\"tags\":[],\"likes\":2,\"follow\":true},{\"id\":\"0\",\"title\":\"project0\",\"smallDescription\":\"small description of project0\",\"status\":\"CONCEPT\",\"img\":\"https://picsum.photos/510/300?random\",\"owner\":{\"id\":\"0\",\"username\":\"test\",\"firstName\":\"test\",\"lastName\":\"test\",\"bio\":\"test\",\"picture\":\"test\"},\"created\":null,\"tags\":[],\"likes\":2,\"follow\":true}]";

        assertThat(result.getResponse().getContentAsString()).isEqualTo(expectedResult);
    }

    @Test
    public void getFeedIncorrectly() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/projectfeed/all?page=1&size=10")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200)).andReturn();

        String expectedResult = "[]";

        assertThat(result.getResponse().getContentAsString()).isEqualTo(expectedResult);
    }
}
