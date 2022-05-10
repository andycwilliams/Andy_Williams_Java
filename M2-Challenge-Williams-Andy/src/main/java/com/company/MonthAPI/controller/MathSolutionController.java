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

    @RequestMapping(value="/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution addSolution(@RequestBody MathSolution mathSolution) {
        mathSolution.addInt(mathSolution.getOperand1(), mathSolution.getOperand2());
        tests.add(mathSolution);
        return mathSolution;
    }

    @RequestMapping(value="/subtract", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution subtractSolution(@RequestBody MathSolution mathSolution) {
        mathSolution.subtractInt(mathSolution.getOperand1(), mathSolution.getOperand2());
        tests.add(mathSolution);
        return mathSolution;
    }

    @RequestMapping(value="/multiply", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution multiplySolution(@RequestBody MathSolution mathSolution) {
        mathSolution.multiplyInt(mathSolution.getOperand1(), mathSolution.getOperand2());
        tests.add(mathSolution);
        return mathSolution;
    }

    @RequestMapping(value="/divide", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution divideSolution(@RequestBody MathSolution mathSolution) {
        mathSolution.divideInt(mathSolution.getOperand1(), mathSolution.getOperand2());
        tests.add(mathSolution);
        return mathSolution;
    }
}