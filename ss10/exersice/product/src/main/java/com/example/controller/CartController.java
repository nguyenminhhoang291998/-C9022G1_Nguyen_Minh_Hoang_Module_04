package com.example.controller;

import com.example.dto.CartDto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping("")
    public String showCart(@SessionAttribute(value = "cart",required = false)CartDto cart,Model model){
        model.addAttribute("countTotalPayment" ,cart.countTotalPayment());
        model.addAttribute("cart",cart);
        return "cart/list";
    }

    @RequestMapping("result")
    public String result(){
        return "cart/result";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id, @SessionAttribute(value = "cart",required = false)CartDto cart){
        cart.delete(id);
        return "redirect:/cart";
    }

    @RequestMapping("/decrease/{id}/{value}")
    public String decrease(@PathVariable int value, @PathVariable int id,
                           @SessionAttribute(value = "cart",required = false)CartDto cart){
        cart.decreaseValue(id,value);
        return "redirect:/cart";
    }

    @RequestMapping("/increase/{id}/{value}")
    public String increase(@PathVariable int value, @PathVariable int id,
                           @SessionAttribute(value = "cart",required = false)CartDto cart){
        cart.increase(id,value);
        return "redirect:/cart";
    }
}
