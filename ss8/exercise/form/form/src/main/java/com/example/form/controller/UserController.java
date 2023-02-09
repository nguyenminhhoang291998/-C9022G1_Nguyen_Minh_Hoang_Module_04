package com.example.form.controller;

import com.example.form.model.User;
import com.example.form.model.UserDto;
import com.example.form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("")
    public String showForm(Model model){
        model.addAttribute("userDto",new UserDto());
        return "/index";
    }

    @RequestMapping("/result")
    public String result(){
        return "/result";
    }

    @PostMapping ("save")
    public String save(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult,
                       Model model, RedirectAttributes redirects){
        new UserDto().validate(userDto,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("userDto",userDto);
            return "/index";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userService.save(user);
        redirects.addFlashAttribute("mess","Sign Up Success");
        return "redirect:/result";
    }
}
