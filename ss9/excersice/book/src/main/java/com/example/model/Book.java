package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Book {
    @Id
    private int id;

    private String name;

    private int quantity;

    @OneToMany(mappedBy = "book")
    private Set<OrderBook> orderBookSet;

    public Book() {
    }

    public Book(int id, String name, int quantity, Set<OrderBook> orderBookSet) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.orderBookSet = orderBookSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<OrderBook> getOrderSet() {
        return orderBookSet;
    }

    public void setOrderSet(Set<OrderBook> orderBookSet) {
        this.orderBookSet = orderBookSet;
    }
}
