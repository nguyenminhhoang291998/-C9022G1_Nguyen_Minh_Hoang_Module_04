package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    boolean save(Product product);

    boolean update(int id,Product product);

    boolean remove(int id);

    Product findById(int id);

    List<Product> findByName(String name);
}
