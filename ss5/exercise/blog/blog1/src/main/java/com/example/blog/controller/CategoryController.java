package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("")
    public String showCategory(Model model){
        model.addAttribute("cate", new Category());
        model.addAttribute("categoryList", categoryService.findAll());
        return "/category";
    }

    @PostMapping("save")
    public String save(@ModelAttribute Category category, RedirectAttributes redirect){
        categoryService.save(category);
        redirect.addFlashAttribute("mess","Thêm thành công");
        return "redirect:/category";
    }
    @PostMapping("update")
    public String update(@ModelAttribute Category category, RedirectAttributes redirect){
        categoryService.save(category);
        redirect.addFlashAttribute("mess","Sửa thành công");
        return "redirect:/category";
    }

    @PostMapping("delete")
    public String save(@RequestParam int deleteId, RedirectAttributes redirect){
        categoryService.delete(deleteId);
        redirect.addFlashAttribute("mess","Xóa thành công");
        return "redirect:/category";
    }


}
