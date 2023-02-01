package com.example;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("")
    public String home(){
        return "/home";
    }
    @RequestMapping("calculator")
    public String result(@RequestParam double value1, @RequestParam double value2, @RequestParam String calculation, Model model){
        String result = "";
        switch (calculation){
            case "Addition":
                result = value1 + " + " +value2 + " = " + (value1 + value2);
                break;
            case "Subtraction":
                result =  value1 + " - " +value2 + " = " + (value1 - value2);
                break;
            case "Multiplication":
                result =  value1 + " X " +value2 + " = " + (value1 * value2);
                break;
            case "Division":
                if(value2 == 0){
                    result = "Không thể chia cho 0";
                    break;
                }
                result =  value1 + " / " +value2 + " = " + (value1 / value2);
                break;
        }
        model.addAttribute("result",result);
        return "/home";
    }
}
