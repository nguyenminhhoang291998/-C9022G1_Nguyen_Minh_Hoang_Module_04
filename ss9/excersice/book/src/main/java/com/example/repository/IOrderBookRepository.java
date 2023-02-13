package com.example.repository;

import com.example.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderBookRepository extends JpaRepository<OrderBook,Integer> {

    OrderBook findByOrOrderCode(int id);
}
