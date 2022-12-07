package com.example.backend;

import com.example.backend.model.entity.Diet;
import com.example.backend.model.entity.UserMealKey;
import com.example.backend.model.repository.DietRepository;
import com.example.backend.model.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.backend.model.entity.User;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DietTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DietRepository dietRepository;

    @Test
    void getDiet() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(get("/diet/1111"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());
        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);

        //UserMealKey dietKey = new UserMealKey(receivedJson.get("clientId").longValue(),receivedJson.get("mealType").textValue(),receivedJson.get("dayYear").textValue());
        //assertTrue(dietRepository.findById(dietKey).isPresent());

        //Diet gotDiet = dietRepository.findById(dietKey).get();

        assertEquals(1111L, receivedJson.get("clientId").longValue());
        assertEquals("Breakfast", receivedJson.get("mealType").textValue());
        assertEquals("December2,2022", receivedJson.get("dayYear").textValue());
        assertEquals("Eggs and toast", receivedJson.get("mealName").textValue());
        assertEquals(300, receivedJson.get("calories").floatValue());
        assertEquals(20.6, receivedJson.get("sugar").floatValue());
        assertEquals(34.5, receivedJson.get("carbs").floatValue());
        assertEquals(19.5, receivedJson.get("protein").floatValue());
        assertEquals(12.7, receivedJson.get("fat").floatValue());
    }
}
