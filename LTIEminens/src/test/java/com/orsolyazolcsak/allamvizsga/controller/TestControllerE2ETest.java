package com.orsolyazolcsak.allamvizsga.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class TestControllerE2ETest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private TestRepository repository;

    @Before
    public void setUp() throws Exception{
        repository.deleteAll();
    }

    @Test
    public void whenCreateNewTest_thenItIsCreated() throws Exception{
        //com.orsolyazolcsak.allamvizsga.model.Test newTest = new com.orsolyazolcsak.allamvizsga.model.Test();
        //newTest.setName("EzIttEgyUjTeszt");
        mvc.perform( MockMvcRequestBuilders
                .post("/test")
                //.param("name", "EzIttEgyUjTeszt")
                .content(asJsonString(new com.orsolyazolcsak.allamvizsga.model.Test("EzIttEgyUjTeszt")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
           /*     .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.name").value("EzIttEgyUjTeszt"));*/
               // .accept(MediaType.APPLICATION_JSON))
                 .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
