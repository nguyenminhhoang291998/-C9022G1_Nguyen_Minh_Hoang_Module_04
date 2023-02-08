package com.example.blog.repository;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IBlogRepository extends CrudRepository<Blog,Integer> {
    Page<Blog> findBySummaryContaining(String name,Pageable pageable);

    Page<Blog> findByCategory_Id(int id,Pageable pageable);

}
