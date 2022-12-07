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

import java.text.DecimalFormat;

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
        MockHttpServletResponse response = mockMvc.perform(get("/diet/1111/Breakfast/December2,2022"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());
        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);

        //UserMealKey dietKey = new UserMealKey(receivedJson.get("clientId").longValue(),receivedJson.get("mealType").textValue(),receivedJson.get("dayYear").textValue());
        //assertTrue(dietRepository.findById(dietKey).isPresent());

        //Diet gotDiet = dietRepository.findById(dietKey).get();

        //DecimalFormat df = new DecimalFormat("#.#");


        //assertEquals(1111L, gotDiet.getUserMealKey().getClientId());
        //assertEquals("Breakfast", gotDiet.getUserMealKey().getMealType());
        //assertEquals("December2,2022", gotDiet.getUserMealKey().getDayYear());
        assertEquals("Eggs and toast", receivedJson.get("mealName").textValue());
        assertEquals(300, receivedJson.get("calories").floatValue());
        assertEquals(20.6, Math.round(receivedJson.get("sugar").floatValue()),1);
        assertEquals(34.5, Math.round(receivedJson.get("carbs").floatValue()), 1);
        assertEquals(19.5, Math.round(receivedJson.get("protein").floatValue()),1);
        assertEquals(12.7, Math.round(receivedJson.get("fat").floatValue()),1);
    }

    @Test
    void addDiet() throws Exception {

        ObjectNode userJson = objectMapper.createObjectNode();
        userJson.put("clientId",1111L);
        userJson.put("mealType","Breakfast");
        userJson.put("dayYear","December2,2022");
        userJson.put("mealName","Eggs and toast");
        userJson.put("calories",300);
        userJson.put("sugar",20.6);
        userJson.put("carbs",34.5);
        userJson.put("protein",19.5);
        userJson.put("fat",12.7);

        MockHttpServletResponse response = mockMvc.perform(
                        post("/diet").
                                contentType("application/json").
                                content(userJson.toString()))
                .andReturn().getResponse();

        // assert HTTP code of response is 200 OK
        assertEquals(200, response.getStatus());
        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);
        UserMealKey dietKey = new UserMealKey(receivedJson.get("clientId").longValue(),receivedJson.get("mealType").textValue(),receivedJson.get("dayYear").textValue());
        assertTrue(dietRepository.findById(dietKey).isPresent());

        Diet gotDiet = dietRepository.findById(dietKey).get();

        assertEquals(1111L, gotDiet.getUserMealKey().getClientId());
        assertEquals("Breakfast", gotDiet.getUserMealKey().getMealType());
        assertEquals("December2,2022", gotDiet.getUserMealKey().getDayYear());
        assertEquals("Eggs and toast", gotDiet.getMealName());
        assertEquals(300, gotDiet.getCalories());
        assertEquals(20.6, gotDiet.getSugar());
        assertEquals(34.5, gotDiet.getCarbs());
        assertEquals(19.5, gotDiet.getProtein());
        assertEquals(12.7, gotDiet.getFat());

    }

    @Test
    void deleteDiet() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                        delete("/diet/1111/Breakfast/December2,2022").
                                contentType("application/json"))
                .andReturn().getResponse();

        UserMealKey dietKey = new UserMealKey(1111L, "Breakfast","December2,2022");
        assertEquals(200, response.getStatus());
        assertTrue(dietRepository.findById(dietKey).isEmpty());
    }
}
