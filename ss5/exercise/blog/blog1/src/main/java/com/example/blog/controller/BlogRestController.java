package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("blog")
    public ResponseEntity<List<Blog>> getAllBlog(){
        List<Blog> blogList = blogService.findAll();
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    @GetMapping("blog/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable int id){
        Blog blog = blogService.findById(id);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(blog,HttpStatus.OK);
    }

    @GetMapping("category")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categoryList = categoryService.findAll();
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }

    @GetMapping("category/{id}")
    public ResponseEntity<List<Blog>> getBlogByCategoryId(@PathVariable int id){
        List<Blog> blogListByCategoryId = blogService.findByCategory_Id(id);
        if(blogListByCategoryId.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(blogListByCategoryId,HttpStatus.OK);
    }
}
