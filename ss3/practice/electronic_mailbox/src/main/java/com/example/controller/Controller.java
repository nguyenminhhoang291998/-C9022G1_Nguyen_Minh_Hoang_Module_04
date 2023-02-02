package com.example.controller;

import com.example.model.Setting;
import com.example.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    SettingService service;

    @ModelAttribute("pages")
    public int[] pages() {
    return new int[]{5, 10, 15, 25, 50, 100};
    }

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("settings",service.getSetting(1));
        return "/home";
    }

    @RequestMapping("update")
    public String update(Model model,@RequestParam int languageId){
        model.addAttribute("settings",service.getSetting(languageId));
        return "/home";
    }
}
