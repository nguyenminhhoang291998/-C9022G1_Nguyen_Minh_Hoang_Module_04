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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;


//    @GetMapping("blog/search/{id}")
//    public ResponseEntity<Blog> getBlog(@PathVariable int id){
//        Blog blog = blogService.findById(id);
//        if(blog == null){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return  new ResponseEntity<>(blog,HttpStatus.OK);
//    }

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
//
//    @GetMapping("blog")
//    public ResponseEntity<List<Blog>> getAllBlog(){
//        List<Blog> blogList = blogService.findAll();
//        if(blogList.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return  new ResponseEntity<>(blogList,HttpStatus.OK);
//    }


    @GetMapping("blog")
    public ResponseEntity<Page<Blog>> search(@RequestParam(required = false,defaultValue = "") String content,
                                             @RequestParam(required = false,defaultValue = "2") int pageSize,
                                             @RequestParam(required = false,defaultValue = "0") int page){

        Pageable pageable = PageRequest.of(page,pageSize);
        Page<Blog> pageBlogByContent= blogService.search(content,pageable);
        if(pageBlogByContent.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(pageBlogByContent,HttpStatus.OK);
    }
}
