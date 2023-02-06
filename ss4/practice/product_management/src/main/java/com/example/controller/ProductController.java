package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "/home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("products", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirect) {
        boolean check = productService.save(product);
        String mess = "Thêm mới thành công";
        if (!check) {
            mess = "Thêm mới thất bại";
        }
        redirect.addFlashAttribute("mess", mess);
        return "redirect:/product";
    }

    @GetMapping("/edit{id}")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirect) {
        boolean check = productService.update(product.getId(), product);
        String mess = "Sửa thành công";
        if (!check) {
            mess = "Sửa thất bại";
        }
        redirect.addFlashAttribute("mess", mess);
        return "redirect:/product";
    }

    @PostMapping("/remove")
    public String remove(int deleteName, RedirectAttributes redirect) {
        boolean check = productService.remove(deleteName);
        String mess = "Xóa thành công";
        if (!check) {
            mess = "Xóa thất bại";
        }
        redirect.addFlashAttribute("mess", mess);
        return "redirect:/product";
    }

    @PostMapping("/search")
    public String search(@RequestParam String searchInfor, Model model) {
        List<Product> products = productService.findByName(searchInfor);
        String mess = "";
        if (products.isEmpty()){
            mess = "Danh sách trống";
        }
        model.addAttribute("mess", mess);
        model.addAttribute("products", products);
        return "/home";
    }
}
