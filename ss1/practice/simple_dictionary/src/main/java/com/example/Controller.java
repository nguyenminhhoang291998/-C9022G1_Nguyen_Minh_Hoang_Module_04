package com.example;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("")
    public String show(){
        return "/home";
    }

    @PostMapping("/translation")
    public String result(@RequestParam String data, Model model){
        String result = "Không tìm thấy dữ liệu";
        switch (data){
            case "Táo":
                result = "Apple";
                break;
            case "Cam":
                result = "Orange";
                break;
            case "Ổi":
                result = "Guava";
                break;
            case "Xoài":
                result = "Mango";
                break;
        }
        model.addAttribute("result", result);
        return "/home";
    }
}
