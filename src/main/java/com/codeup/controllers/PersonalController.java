package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Scanner;

/**
 * Created by everardosifuentes on 6/19/17.
 */

@Controller
public class PersonalController {

    //call resume view
    @GetMapping("/resume")
    public String viewResume() {
        return "resume";
    }


    //call portfolio view
    @GetMapping("/portfolio")
    public String viewPortfolio() {
        return "portfolio";
    }


    //call portfolio view
    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable int guess, Model model) {
        int random = (int )(Math.random() * 6 + 1);

       /* Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:  ");
        int Unum = sc.nextInt();*/

        model.addAttribute("Rnum", random);
        model.addAttribute("Gnum", guess);

        return "roll-dice";

    }





}
