package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showList(Model model,@RequestParam(required = false,defaultValue = "") String searchInfor
    ,@RequestParam(required = false,defaultValue = "0") int page,
                           @RequestParam(required = false,defaultValue ="id") String sortName){
        Pageable pageable = PageRequest.of(page,5, Sort.by(sortName).ascending());
        Page<Blog> blogPage = blogService.search(searchInfor,pageable);
        model.addAttribute("blogList",blogPage);
        model.addAttribute("searchInfor",searchInfor);
        model.addAttribute("bl", new Blog());
        model.addAttribute("categoryList", categoryService.findAll());
        return "/home";
    }

    @GetMapping("group")
    public String group(Model model,@RequestParam(required = false) int categoryId
    ,@RequestParam(required = false,defaultValue = "0") int page,
                           @RequestParam(required = false,defaultValue ="id") String sortName){
        Pageable pageable = PageRequest.of(page,5, Sort.by(sortName).ascending());
        Page<Blog> blogPage = blogService.findByCategory_Id(categoryId,pageable);
        model.addAttribute("blogList",blogPage);
        model.addAttribute("categoryId",categoryId);
        model.addAttribute("bl", new Blog());
        model.addAttribute("categoryList", categoryService.findAll());
        return "/home";
    }

    @PostMapping("save")
    public String save(RedirectAttributes redirect, @ModelAttribute Blog blog){
        blog.setCreatedDay(LocalDate.now());
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
