package com.gb.may.market.controllers;

import com.gb.may.market.beans.Cart;
import com.gb.may.market.entities.Order;
import com.gb.may.market.entities.User;
import com.gb.may.market.services.OrdersService;
import com.gb.may.market.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/orders")
@AllArgsConstructor
public class OrdersController {
    private UsersService usersService;
    private OrdersService ordersService;
    private Cart cart;

    @GetMapping("/create")
    public String createOrder (Principal principal, Model model){
        User user = usersService.findByPhone(principal.getName()).get();
        model.addAttribute("user", user);
        return "order_info";
    }

    @PostMapping("/confirm")
    @ResponseBody
    public String confirmOrder (Principal principal, @RequestParam String address, @RequestParam String phone){
        User user = usersService.findByPhone(principal.getName()).get();
        Order order = new Order(user,cart,phone, address);
        order = ordersService.saveOrder(order);
        return "Order number " + order.getId() + " Total price: " + order.getPrice();
    }
}
