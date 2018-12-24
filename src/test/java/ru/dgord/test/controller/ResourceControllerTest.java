package ru.dgord.test.controller;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class ResourceControllerTest {
    @InjectMocks
    private ResourceController resourceController;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(resourceController).build();
    }

    @Test
    public void getResources() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/resources")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("It\'s simple resource!"));
    }

    @Test
    public void getJsonResource() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/resources/json")
                    .accept(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.text", Matchers.is("Hello, world!")));
    }
}