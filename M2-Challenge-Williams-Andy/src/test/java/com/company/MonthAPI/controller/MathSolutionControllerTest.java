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
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

    @Test
    public void shouldThrow422IfOneOperandIsMissingOrNotANumber() throws Exception {
        MathSolution expectedResult = new MathSolution();
        expectedResult.setOperand2(7);
        String inputJSON = mapper.writeValueAsString(expectedResult);

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
    public void shouldThrow422IfTryToDivideByZero() throws Exception {
        MathSolution expectedResult = new MathSolution(42, 0, "divide", null);
        String inputJSON = mapper.writeValueAsString(expectedResult);

        mockMvc.perform(post("/divide")
                        .content(inputJSON)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}
