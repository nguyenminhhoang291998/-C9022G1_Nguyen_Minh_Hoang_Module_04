package com.example.service;

import com.example.model.OrderBook;

public interface IOrderBookService {
    void save(OrderBook orderBook);

    OrderBook findByBookCode(int id);
}
