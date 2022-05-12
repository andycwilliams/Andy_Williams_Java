package com.company.MonthAPI.controller;

import com.company.MonthAPI.model.MathSolution;
import com.company.MonthAPI.model.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(MonthApiController.class)
public class MonthApiControllerTest {

    @Autowired
    MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {
        // This is the standard set up method that runs before each test. It's typically used for instantiating test
        // objects. We don't have to do anything special for mockMvc since it's Autowired. We will however be using
        // setUp() in the future.
    }

    @Test
    public void shouldConvertMonth() throws Exception {
        Month month = new Month();
        month.setNumber(7);
        month.setName("July");

        String outputJson = mapper.writeValueAsString(month);

        mockMvc.perform(get("/month/7"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    // MockMVC test for input out of range.

    @Test
    public void shouldGet422ForOutOfRangeMonth() throws Exception {
        Month month = new Month();
        month.setNumber(123);
        month.setName("Super January");

        String inputJSON = mapper.writeValueAsString(month);

        mockMvc.perform(
                        get("/month/123")
                                .content(inputJSON)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldGetRandomMonth() throws Exception {
            Random rando = new Random();
            int randoInt = rando.nextInt(12); // Makes sure it's between 0 and one less than the bound number
            int correctedInt = randoInt + 1;

            Month findMonth = null;
//
//            for (Month month : ) {
//                if (month.getNumber() == correctedInt) {
//                    findMonth = month;
//                }
//            }

        mockMvc.perform(
                        get("/month")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }
}
