package com.example.backend;


import com.example.backend.model.entity.Diet;
import com.example.backend.model.entity.UserMealKey;
import com.example.backend.model.repository.DietRepository;
import com.example.backend.model.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class DietTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DietRepository dietRepository;
    @Autowired
    private UserMealKey userMealKey;

    @Test
    void getDiet() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(get("/diet/1111"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());

        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);

        UserMealKey dietKey = new UserMealKey(receivedJson.get("clientId").longValue(),receivedJson.get("mealType").toString(),receivedJson.get("dayYEar").toString());

        assertTrue(dietRepository.findById(dietKey).isPresent());

        Diet gotDiet = dietRepository.findById(dietKey).get();

        //assertEquals(1111L, receivedJson.get("clientId").longValue());
        //assertEquals("Michael", receivedJson.get("firstName").textValue());
        //assertEquals("Scott", receivedJson.get("lastName").textValue());
        //assertEquals(49, receivedJson.get("age").intValue());
        //assertEquals(176.0, receivedJson.get("height").floatValue());
        //assertEquals(170.0, receivedJson.get("weight").floatValue());
        //assertEquals("111", receivedJson.get("password").textValue());
    }

}

