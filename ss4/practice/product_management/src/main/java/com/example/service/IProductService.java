package com.example.service;

import com.example.model.Product;
import jdk.nashorn.internal.runtime.PrototypeObject;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    boolean save(Product product);

    boolean update(int id,Product product);

    boolean remove(int id);

    Product findById(int id);

    List<Product> findByName(String name);
}
