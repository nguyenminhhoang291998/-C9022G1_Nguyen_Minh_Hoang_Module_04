package com.example.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("")
    public String show() {
        return "/home";
    }
    @PostMapping("/conversion")
    public String result(@RequestParam int number, Model model){
        model.addAttribute("result","Kết quả quy đổi " + number + " USD = " + number*23000 + " VND");
        return "/home";
    }
}

