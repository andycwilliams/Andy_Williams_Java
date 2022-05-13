package com.company.MonthAPI.controller;

import com.company.MonthAPI.model.Month;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class MonthApiController {

    private static List<Month> monthList = new ArrayList<>(Arrays.asList(
            new Month(1, "January"),
            new Month(2, "February"),
            new Month(3, "March"),
            new Month(4, "April"),
            new Month(5, "May"),
            new Month(6, "June"),
            new Month(7, "July"),
            new Month(8, "August"),
            new Month(9, "September"),
            new Month(10, "October"),
            new Month(11, "November"),
            new Month(12, "December")
    ));

    @RequestMapping(value = "/month", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Month> getAllMonths() {
        return monthList;
    }

    @RequestMapping(value = "/month/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Month getMonthByNumber(@PathVariable int id) {

        if (id < 1 || id > 12) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Number must be between 1 and 12.");
        }

        Month findMonth = null;

        for (Month month : monthList) {
            if (month.getNumber() == id) {
                findMonth = month;
            }
        }
        return findMonth;
    }

    // Every request mapping annotation needs to have a method
    @RequestMapping(value = "/randomMonth", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Month getRandomMonth() {

        Random rando = new Random();
        int randoInt = rando.nextInt(12); // Makes sure it's between 0 and one less than the bound number
        int correctedInt = randoInt + 1;

        Month findMonth = null;

        for (Month month : monthList) {
            if (month.getNumber() == correctedInt) {
                findMonth = month;
            }
        }
        return findMonth;
    }
}