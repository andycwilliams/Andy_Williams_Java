package com.company.MonthAPI.controller;

import com.company.MonthAPI.model.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MathSolutionController {

    @RequestMapping(value="/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public MathSolution addSolution(@RequestBody MathSolution mathSolution) {
        if (mathSolution.getOperand1() instanceof Integer || mathSolution.getOperand2() instanceof Integer) {
            System.out.println("IS INTEGER");
        } else { throw new IllegalArgumentException("Both operands must be numbers."); }

        mathSolution.setOperation("add");
        mathSolution.setAnswer(mathSolution.getOperand1() + mathSolution.getOperand2());
        return mathSolution;
    }

    @RequestMapping(value="/subtract", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public MathSolution subtractSolution(@RequestBody MathSolution mathSolution) {
        if (mathSolution.getOperand1() instanceof Integer || mathSolution.getOperand2() instanceof Integer) {
            System.out.println("IS INTEGER");
        } else { throw new IllegalArgumentException("Both operands must be numbers."); }

        mathSolution.setOperation("subtract");
        mathSolution.setAnswer(mathSolution.getOperand1() - mathSolution.getOperand2());
        return mathSolution;
    }

    @RequestMapping(value="/multiply", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public MathSolution multiplySolution(@RequestBody MathSolution mathSolution) {
        if (mathSolution.getOperand1() instanceof Integer || mathSolution.getOperand2() instanceof Integer) {
            System.out.println("IS INTEGER");
        } else { throw new IllegalArgumentException("Both operands must be numbers."); }

        mathSolution.setOperation("multiply");
        mathSolution.setAnswer(mathSolution.getOperand1() * mathSolution.getOperand2());
        return mathSolution;
    }

    @RequestMapping(value="/divide", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public MathSolution divideSolution(@RequestBody MathSolution mathSolution) {
        if (mathSolution.getOperand1() instanceof Integer || mathSolution.getOperand2() instanceof Integer) {
            System.out.println("IS INTEGER");
        } else { throw new IllegalArgumentException("Both operands must be numbers."); }

        if (mathSolution.getOperand2() == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }

        mathSolution.setOperation("divide");
        mathSolution.setAnswer(mathSolution.getOperand1() / mathSolution.getOperand2());
        return mathSolution;
    }
}