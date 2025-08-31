package com.example.Restaurant.controller;

import com.example.Restaurant.modell.Drink;
import com.example.Restaurant.modell.Menu;
import com.example.Restaurant.modell.Order;
import com.example.Restaurant.modell.Pizza;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@AllArgsConstructor


public class OrderHandling {
    private ArrayList<Order> orders = new ArrayList<>();

    private final Menu menu = new Menu();

    private Order currentOrder;

    @PostMapping("/order/create")
    public void craeteOrder() {
        this.currentOrder = new Order();

    }
    @GetMapping("/order/{id}")
    public Order getOrder(){
        if (this.currentOrder == null) {
            throw new IllegalStateException("No order has been created yet.");
        }
        return this.currentOrder;
    }

    @PostMapping("/order/addPizza/{id}")
    public void addPizza(@PathVariable int id) {
        this.currentOrder.addPizza(menu.getPizzaByID(id));
    }
    /*
    numberofDrinks / pizza mindig mutassa, hogy hány pizza van berakva?
   */
    @PostMapping("/order/addDrink/{id}")
    public void addDrink(@PathVariable int id) {
        this.currentOrder.addDrink(menu.getDrinksByID(id));
    }

    @GetMapping("/order/closeOrder")
    public void closeOrder() {
        if (this.currentOrder == null) {
            throw new IllegalStateException("No order has been created yet.");
        }
        orders.add(currentOrder);
        currentOrder = null;
    }
    @GetMapping("/getOrders")
    public ArrayList<Order> getOrders(){
        if (this.orders.isEmpty()) {
            throw new IllegalStateException("No order has been created yet.");
        }
        return this.orders;
    }
    @GetMapping("/menu/pizzas")
    @ResponseBody
    public List<Pizza> getPizzas() {
        return menu.getPizzaList();
    }

    @GetMapping("/menu/drinks")
    @ResponseBody
    public List<Drink> getDrinks() {
        return menu.getDrinkList();
    }
}