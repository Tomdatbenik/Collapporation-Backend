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
                        .header("Authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzUxMiJ9.eyJ1c2VySW1hZ2UiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vYS0vQU9oMTRHaEpzN1pqaXpVWGtWbXNZRFZlVmdyQ00xdjlvRHZIclNlOTJIYklKdyIsImlzcyI6ImNvbGxhcHBlcmF0aW9uLXRva2VuLXNlcnZpY2UiLCJleHAiOjE1OTIwMzcyNTgsInVzZXJOYW1lIjoiV29uZGVyZnVsUHVnaWxpc3QiLCJpYXQiOjE1OTA1NjYwMjksInV1aWQiOiJmZlU2Z1pudU9maGpidjFlV09OMmJoVnV6azgzIiwianRpIjoiOWJlNWU5OTEtNzIzNi00Mjk2LWFhNjctN2FkMDM5NDczMjRkIn0.TYpspJtOQlgntNpxDnEHUGBUj8oyABBo4HfB8OElNDtf428KQTHj8uhPoMxKYaJDkFpo4FeZN3Wl66GiPhiYYVnEcupatliRRYadK3IklFD30FbJW9NLgRaFu3buZBpqXAu_tUIBC0Egb8jQT6ETipDr54_r3cQirmsNtU5RUls")
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