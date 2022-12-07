package com.example.backend;

import com.example.backend.model.entity.Diet;
import com.example.backend.model.entity.UserMealKey;
import com.example.backend.model.entity.UserSleepKey;
import com.example.backend.model.repository.DietRepository;
import com.example.backend.model.repository.SleepRepository;
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
public class SleepTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SleepRepository sleepRepository;

    @Test
    void getDiet() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(get("/sleep/1111/December2,2022"))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());
        ObjectNode receivedJson = objectMapper.readValue(response.getContentAsString(), ObjectNode.class);


        assertEquals(6.5, Math.round(receivedJson.get("duration").floatValue()),1);
        assertEquals(4, receivedJson.get("restScore").floatValue());
        assertEquals(true, receivedJson.get("dream").asBoolean());
        assertEquals(true, receivedJson.get("alarmWakeUp").asBoolean());
        assertEquals(1,receivedJson.get("numNaps").floatValue());
    }
    @Test
    void deleteDiet() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                        delete("/sleep/1111/December2,2022").
                                contentType("application/json"))
                .andReturn().getResponse();

        UserSleepKey sleepKey = new UserSleepKey(1111L,"December2,2022");
        assertEquals(200, response.getStatus());
        assertTrue(sleepRepository.findById(sleepKey).isEmpty());
    }

}


