package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        List<Product> productList;
        productList = entityManager.createQuery("select p From Product as p").getResultList();
        return productList;

    }

    @Transactional
    @Override
    public boolean save(Product product) {
        entityManager.persist(product);
        return true;
    }

    @Transactional
    @Override
    public boolean update(int id, Product product) {
        Product pro = findById(product.getId());
        if(pro == null){
            return false;
        }
        pro.setName(product.getName());
        pro.setPrice(product.getPrice());
        pro.setDescribes(product.getDescribes());
        pro.setProducer(product.getProducer());
        entityManager.merge(pro);
        return true;
    }

    @Transactional
    @Override
    public boolean remove(int id) {
        Product pro = findById(id);
        if(pro == null){
            return false;
        }
        entityManager.remove(pro);
        return true;
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class,id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList;
        productList = entityManager.createQuery("select p From Product as p where p.name like  :ProductName").setParameter("ProductName","%"+name+"%").getResultList();
        return productList;
    }
}
