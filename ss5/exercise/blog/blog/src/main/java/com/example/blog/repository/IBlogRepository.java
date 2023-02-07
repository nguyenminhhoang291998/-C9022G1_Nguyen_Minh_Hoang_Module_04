package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.repository.CrudRepository;

public interface IBlogRepository extends CrudRepository<Blog,Integer> {
}
