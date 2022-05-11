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
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(30);
        mathSolution.setOperand2(90);
        mathSolution.setOperation("add");
        mathSolution.setAnswer(120);
    }

    @Test
    public void shouldSubtractOperands() throws Exception {
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(17);
        mathSolution.setOperand2(5);
        mathSolution.setOperation("subtract");
        mathSolution.setAnswer(12);
    }

    @Test
    public void shouldMultiplyOperands() throws Exception {
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(10);
        mathSolution.setOperand2(8);
        mathSolution.setOperation("multiply");
        mathSolution.setAnswer(80);
    }

    @Test
    public void shouldDivideOperands() throws Exception {
        MathSolution mathSolution = new MathSolution();
        mathSolution.setOperand1(42);
        mathSolution.setOperand2(2);
        mathSolution.setOperation("divide");
        mathSolution.setAnswer(21);
    }
}
