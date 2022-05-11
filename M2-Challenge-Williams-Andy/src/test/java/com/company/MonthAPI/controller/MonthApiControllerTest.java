package com.company.MonthAPI.controller;

import com.company.MonthAPI.model.MathSolution;
import com.company.MonthAPI.model.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @Test
    public void shouldGetRandomMonth() throws Exception {
//        Month month = new Month();
//        month.setNumber(7);
//        month.setName("July");
//
//        String outputJson = mapper.writeValueAsString(month);
//
//        mockMvc.perform(get("/month/7"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().json(outputJson));
    }
}
