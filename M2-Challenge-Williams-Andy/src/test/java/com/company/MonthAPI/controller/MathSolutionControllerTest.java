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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathSolutionController.class)
public class MathSolutionControllerTest {

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
    public void shouldAddOperands() throws Exception {
        MathSolution expectedResult = new MathSolution(30, 90, "add", 120);
        String outputJSON = mapper.writeValueAsString(expectedResult);

        MathSolution actualResult = new MathSolution(30, 90);
        String inputJSON = mapper.writeValueAsString(actualResult);

        mockMvc.perform(post("/add").content(inputJSON).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJSON));
    }

    // Error: 422, if missing operand or if operands are not both numbers

    @Test
    public void shouldThrow422IfOneAddOperandIsMissingOrAreNotStrings() throws Exception {
        MathSolution expectedResult = new MathSolution(null, 7, "add", 100);
        String inputJSON = mapper.writeValueAsString(expectedResult);

//        MathSolution expectedResult2 = new MathSolution("", 7, "add", 100);
//        String inputJSON2 = mapper.writeValueAsString(expectedResult2);

        mockMvc.perform(post("/add").content(inputJSON).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldSubtractOperands() throws Exception {
        MathSolution expectedResult = new MathSolution(17, 5, "subtract", 12);
        String outputJSON = mapper.writeValueAsString(expectedResult);

        MathSolution actualResult = new MathSolution(17, 5);
        String inputJSON = mapper.writeValueAsString(actualResult);

        mockMvc.perform(post("/subtract").content(inputJSON).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJSON));
    }

    @Test
    public void shouldThrow422IfOneSubtractOperandIsMissingOrAreNotStrings() throws Exception {

    }

    @Test
    public void shouldMultiplyOperands() throws Exception {
        MathSolution expectedResult = new MathSolution(10, 8, "multiply", 80);
        String outputJSON = mapper.writeValueAsString(expectedResult);

        MathSolution actualResult = new MathSolution(10, 8);
        String inputJSON = mapper.writeValueAsString(actualResult);

        mockMvc.perform(post("/multiply").content(inputJSON).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJSON));
    }

    @Test
    public void shouldThrow422IfOneMultiplyOperandIsMissingOrAreNotStrings() throws Exception {

    }

    @Test
    public void shouldDivideOperands() throws Exception {
        MathSolution expectedResult = new MathSolution(42, 2, "divide", 21);
        String outputJSON = mapper.writeValueAsString(expectedResult);

        MathSolution actualResult = new MathSolution(42, 2);
        String inputJSON = mapper.writeValueAsString(actualResult);

        mockMvc.perform(post("/divide").content(inputJSON).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJSON));
    }

    @Test
    public void shouldThrow422IfOneADivideOperandIsMissingOrAreNotStrings() throws Exception {

    }

    // MockMVC test for invalid request - ALL FOUR
}
