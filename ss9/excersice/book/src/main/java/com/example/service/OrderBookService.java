package com.example.service;

import com.example.model.OrderBook;
import com.example.repository.IOrderBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderBookService implements IOrderBookService {
    @Autowired
    IOrderBookRepository orderBookRepository;

    @Override
    public void save(OrderBook orderBook) {
        orderBookRepository.save(orderBook);
    }

    @Override
    public OrderBook findByBookCode(int id) {
        return orderBookRepository.findByOrOrderCode(id);
    }
}
