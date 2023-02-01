package com.example;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("")
    public String show(){
        return "/index";
    }

    @RequestMapping("/save")
    public String save(@RequestParam("condiment") String[] condiment, Model model) {
        String condiments = Arrays.toString(condiment);
        model.addAttribute("condiments",condiments);
        return "/result";
    }
}
