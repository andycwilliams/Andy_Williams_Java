package com.company.MonthAPI.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Month;
import java.util.List;

@RestController
public class MonthApiController {

    @RequestMapping(value = "/randomMonth", method = RequestMethod.GET)
//    public List<Student> getStudents() {
//        return studentList;
//    }



//    java.time.Month Converter:
//    URI: /month/{monthNumber}
//    HTTP Method: GET
//    Request Body: None
//    Response Body: A Month object containing the name and number of the requested month (1—January, 2—February, etc.)
//    Error: 422, if the input is out of range



    @RequestMapping(value = "/month/{monthNumber}", method = RequestMethod.GET)
    public String echo(@PathVariable String input) {
        return input;
    }