package com.company.MonthAPI.controller;

import com.company.MonthAPI.model.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MathSolutionController {

    private static List<MathSolution> tests = new ArrayList<>(Arrays.asList(
            new MathSolution(1,2,"add",3),
            new MathSolution(14,12,"subtract",2),
            new MathSolution(5,3,"multiply",15),
            new MathSolution(40,5,"divide",8)
    ));

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<MathSolution> getAllMathSolutions() {
        return tests;
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public MathSolution addSolution(@RequestBody MathSolution mathSolution) {
        if (mathSolution.getOperand1() instanceof Integer || mathSolution.getOperand2() instanceof Integer) {
            System.out.println("IS INTEGER");
        } else { throw new IllegalArgumentException("Both operands must be numbers."); }

        mathSolution.setOperation("add");
        mathSolution.setAnswer(mathSolution.getOperand1() + mathSolution.getOperand2());
        tests.add(mathSolution);
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
        tests.add(mathSolution);
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
        tests.add(mathSolution);
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
        tests.add(mathSolution);
        return mathSolution;
    }
}