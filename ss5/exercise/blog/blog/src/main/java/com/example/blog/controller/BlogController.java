package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("blogList",blogService.findAll());
        model.addAttribute("bl", new Blog());
        return "/home";
    }
    @PostMapping("save")
    public String save(RedirectAttributes redirect, @ModelAttribute Blog blog){
        blogService.save(blog);
        redirect.addFlashAttribute("mess", "Thêm thành công");
        return "redirect:/";
    }
    @PostMapping("update")
    public String update(RedirectAttributes redirect, @ModelAttribute Blog blog){
        blogService.save(blog);
        redirect.addFlashAttribute("mess", "Cập nhật thành công");
        return "redirect:/";
    }

    @PostMapping("delete")
    public String delete(RedirectAttributes redirect, @RequestParam  int deleteId){
        blogService.delete(deleteId);
        redirect.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/";
    }

}
