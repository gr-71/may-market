package com.gb.may.market.services;

import com.gb.may.market.entities.Order;
import com.gb.may.market.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    private OrdersRepository ordersRepository;

    @Autowired
    public void setOrdersRepository(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public Order saveOrder (Order order){
        return ordersRepository.save(order);
    }
}
