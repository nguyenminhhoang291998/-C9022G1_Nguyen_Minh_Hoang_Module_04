package com.example.controller;

import com.example.dto.CartDto;
import com.example.dto.ProductDto;
import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @ModelAttribute("cart")
    public CartDto initCart(){
        return new CartDto();
    }

    @Autowired
    private IProductService productService;

    @RequestMapping("")
    public String showList(Model model,@SessionAttribute(value = "cart",required = false)CartDto cart){
        model.addAttribute("productList",productService.findAll());
        return "product/home";
    }

    @RequestMapping("add")
    public String add(@RequestParam int productId, @SessionAttribute(value = "cart")CartDto cart){
        Product product = productService.findById(productId);
        if(product != null){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }
}
