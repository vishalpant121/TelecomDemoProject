package com.demo.telecom.subscriberservice;

import com.demo.telecom.subscriberservice.dto.SubscriberRequest;
import com.demo.telecom.subscriberservice.repository.SubscriberRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class SubscriberServiceApplicationTests {


    @Container
    private MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.0.24");

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Test
    void shouldCreateSubscriber() throws Exception {
        SubscriberRequest subscriberRequest = new SubscriberRequest
                ("123", "Vishal", 12, null, null, 12, "uttarakhand");
        String subscriberString = objectMapper.writeValueAsString(subscriberRequest);
        mockMvc.perform(MockMvcRequestBuilders.post("/subs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(subscriberString))
                .andExpect(status().isCreated());

    }

  //  @Test
    void shouldGetSubscriber() throws Exception {

        String id = "123";
        mockMvc.perform(MockMvcRequestBuilders.get("/subs")
                .content(id))
                .andExpect(status().isOk());
    }



}
