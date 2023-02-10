package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Page<Blog> search(String name, Pageable pageable);

    void save(Blog blog);
    Blog findById(int id);
    void delete(int id);
    Page<Blog> findByCategory_Id(int id,Pageable pageable);
}
