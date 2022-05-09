package com.company.MonthAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.util.List;
import java.util.Random;

@RestController
public class MonthApiController {

    @Autowired
    Months month;

        @RequestMapping(value = "/randomMonth", method = RequestMethod.GET)
        @ResponseStatus(HttpStatus.OK)
        public Month getRandomMonth(string index) {
            System.out.println("RANDOM MONTH!");
            return getRandomMonth.get(index);
        }

//    Random Month:
//    URI: /randomMonth
//    HTTP Method: GET
//    Request Body: None
//    Response Body: A Month object containing a randomly selected month

    // ------

//    @RequestMapping(value = "/month/{monthNumber}", method = RequestMethod.GET)
//    public Student convertMonth(@PathVariable int index) {
//        return studentList.get(index);
//    }

//    RequestMapping(value = "/add", method = RequestMethod.POST)

//    RequestMapping(value = "/subtract", method = RequestMethod.POST)

//    RequestMapping(value = "/multiply", method = RequestMethod.POST)

//    RequestMapping(value = "/divide", method = RequestMethod.POST)
}



