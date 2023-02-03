package com.example.service;

import com.example.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {

    private static final Map<Integer, Product> productList = new HashMap<>();

    static {
        productList.put(1, new Product(1, "IphoneX", 4000, "Tow Eyes", "Apple"));
        productList.put(2, new Product(2, "Xiaomi8", 3000, "Tow Eyes", "Xiaomi"));
        productList.put(3, new Product(3, "SamSungA20", 3000, "Tow Eyes", "Sam Sung"));
        productList.put(4, new Product(4, "Iphone11", 5000, "Three Eyes", "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public boolean save(Product product) {
        return productList.put(product.getId(), product) == null;
    }

    @Override
    public boolean update(int id, Product product) {
        return productList.put(id, product) != null;
    }

    @Override
    public boolean remove(int id) {
        return productList.remove(id) != null;
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        for (Product pro : productList.values()) {
            if (pro.getName().contains(name)) {
                products.add(pro);
            }
        }
        return products;
    }
}
