package com.collapporation.likeservice.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Sql(scripts = {"/test/like.sql"})
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class LikeControllerTests {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void likeSuccessfulTest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/like/like").contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzUxMiJ9.eyJ1c2VySW1hZ2UiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vYS0vQU9oMTRHamtFbjVHbC1iZlZhRGxuZ204eHhFOGFfVVJtUkRzNUJkeENaYTlldyIsImlzcyI6ImNvbGxhcHBlcmF0aW9uLXRva2VuLXNlcnZpY2UiLCJleHAiOjE1OTM3NjUxMTUsInVzZXJOYW1lIjoiUm95IEFwcGVsZG9vcm4iLCJpYXQiOjE1OTIyOTM4ODYsInV1aWQiOiJLU2FoRURORjZJVUhicVkwNDE0eGIxbGs0MjczIiwianRpIjoiZTI1MmUyNTItNTQxZS00OWI0LTk5ZDUtNTQzODhjNWE2Y2VlIn0.KZoUob_GLpoeaqVFwDHMXc0LyULTaIfzAPAAKhe7T5jlWyn91ltBEPJpTWDSIEctGmJelwF5BjpU-Qjvp0R_l18aT7ovbYjeZAsA3tC5CIsYSl4MtOklbOevvr8dM2W6sEk9ucxwHBcQP0fzdMaRAXATiHtJIk73E7ICXo_cuMk")
                        .content("{\"object_id\":\"1\",\"liked_by_id\":\"2\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getLikeCount() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/like/count?object_id=1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"object_id\":\"1\",\"count\":2}")));

    }
}