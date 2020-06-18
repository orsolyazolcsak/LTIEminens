package com.orsolyazolcsak.allamvizsga.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orsolyazolcsak.allamvizsga.Application;
import com.orsolyazolcsak.allamvizsga.repository.TestRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = Application.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class TestControllerE2ETest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private TestRepository repository;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Before
    public void setUp() {
        repository.deleteAll();
    }

    @Test
    public void whenCreateNewTest_thenItIsCreated() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .post("/test")
                .content(asJsonString(new com.orsolyazolcsak.allamvizsga.model.Test("EzIttEgyUjTeszt")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }
}
