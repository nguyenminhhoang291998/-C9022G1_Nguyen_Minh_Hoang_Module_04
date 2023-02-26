package com.example.controller;

import com.example.service.IEmployeeService;
import com.example.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class HomeController {
    @Autowired
    private IEmployeeService employeeService;
    @RequestMapping("")
    public String home(Principal principal,Model model){
        try
        {
            String employeeName = employeeService.findByUsername(principal.getName()).getName();
            model.addAttribute("employee",employeeService.findByUsername(principal.getName()));
//            User loginedUser = (User) ((Authentication) principal).getPrincipal();
//            String userInfo = WebUtils.toString(loginedUser);
//            model.addAttribute("userInfo", userInfo);
            return "home";
        }catch (Exception e){
            return "home";
        }
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "loginPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + employeeService.findByUsername(principal.getName()).getName() //
                    + "<br>Sorry ! You do not have permission to access this page!";
            model.addAttribute("message", message);

        }
        return "403Page";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage() {
        return "loginPage";
    }

}
