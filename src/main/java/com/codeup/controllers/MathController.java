package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by everardosifuentes on 6/19/17.
 */

@Controller
public class MathController {

    @GetMapping("/add/3/and/4/{3},{4}")
    @ResponseBody
    public int addTwoNumbers() {
        return 3+4;
    }

    //add any two numbers .. run like this .. /addAny2/6/and/7
    @GetMapping("/addAny2/{num1}/and/{num2}")
    @ResponseBody
    public int addTwoNumbers_(@PathVariable int num1, @PathVariable int num2) {
        return num1 + num2;
    }


    @GetMapping("/subtract/3/from/10/{10},{3}")
    @ResponseBody
    public int subtractTwoNumbers() {
        return 10-3;
    }


    @GetMapping("/multiply/4/and/5/{4},{5}")
    @ResponseBody
    public int multiplyTwoNumbers() {
        return 4*5;
    }


    @GetMapping("/divide/6/by/3/{6},{3}")
    @ResponseBody
    public int divideTwoNumbers() {
        return 6/3;
    }







}




