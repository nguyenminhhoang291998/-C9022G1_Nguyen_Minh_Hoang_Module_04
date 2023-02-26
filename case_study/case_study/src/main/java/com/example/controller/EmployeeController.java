package com.example.controller;

import com.example.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @RequestMapping("")
    public String showList(Model model, @RequestParam(required = false,defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page,4);
        model.addAttribute("employeePage",employeeService.findAll(pageable));
        return "employee";
    }
}
