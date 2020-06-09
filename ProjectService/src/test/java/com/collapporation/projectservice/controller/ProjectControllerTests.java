package com.collapporation.projectservice.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Sql(scripts = {"/test/project.sql"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProjectControllerTests {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void getProjectTest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/project/0")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":\"0\",\"title\":\"project0\",\"smallDescription\":\"small description of project0\",\"status\":\"CONCEPT\",\"img\":\"https://picsum.photos/510/300?random\",\"owner\":0,\"created\":null,\"description\":\"very large markdown description of project0\",\"tags\":null,\"links\":null,\"collaborators\":null,\"comments\":null,\"likes\":null,\"follows\":null}")));
    }

    @Test
    public void createProjectTest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/project/create").contentType(MediaType.APPLICATION_JSON).content("{\"id\": \"\",\"title\": \"test\",\"smallDescription\": \"test kleine beschrijving\",\"description\": \"test beschrijving\",\"status\": \"CONCEPT\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(notNullValue()));
    }

    @Test
    public void createProjectNotValidEntityTest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/project/create").contentType(MediaType.APPLICATION_JSON).content("{\"id\": \"\",\"title\": \"\",\"smallDescription\": \"test kleine beschrijving\",\"description\": \"test beschrijving\",\"status\": \"CONCEPT\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void updateProjectTest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.put("/project/update").contentType(MediaType.APPLICATION_JSON).content("{\"id\": \"0\",\"title\": \"test\",\"smallDescription\": \"test kleine beschrijving\",\"description\": \"test beschrijving\",\"status\": \"CONCEPT\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void updateProjectNotValidEntityTest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.put("/project/update").contentType(MediaType.APPLICATION_JSON).content("{\"id\": \"\",\"title\": \"\",\"smallDescription\": \"test kleine beschrijving\",\"description\": \"test beschrijving\",\"status\": \"CONCEPT\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void getNotFoundTest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/project/9999999").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.NOT_FOUND.value()));
    }
}