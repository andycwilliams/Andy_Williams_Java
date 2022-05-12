package com.company.MonthAPI.controller;

import com.company.MonthAPI.model.Month;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


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

//        if (id < 1 || id > 12) {
//            throw new IllegalArgumentException("Must choose a number between 1 and 12.");
//        }

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

// ------------------------------------------------------------------------

//    public String getTest() {
//        System.out.println("Random number: " + Math.random());
//        return "Month";
//
//    }

//    @RequestMapping(value = "/randomMonth/{id}", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public String getRandomMonth() {
//        System.out.println("Random number: " + Math.random());
//        return "Month";
//
//    }

//    @RequestMapping(value = "/randomMonth", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public Month getRandomMonth(string index) {
//        System.out.println("RANDOM MONTH!");
//        return getRandomMonth.get(index);
//    }

//    Random Month:
//    URI: /randomMonth
//    HTTP Method: GET
//    Request Body: None
//    Response Body: A Month object containing a randomly selected month

//    @RequestMapping(value = "/month/{monthNumber}", method = RequestMethod.GET)
//    public Student convertMonth(@PathVariable int index) {
//        return studentList.get(index);
//    }

//    RequestMapping(value = "/add", method = RequestMethod.POST)

//    RequestMapping(value = "/subtract", method = RequestMethod.POST)

//    RequestMapping(value = "/multiply", method = RequestMethod.POST)

//    RequestMapping(value = "/divide", method = RequestMethod.POST)




