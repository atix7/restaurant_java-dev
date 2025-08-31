package com.example.Restaurant.controller;

import com.example.Restaurant.modell.Menu;
import com.example.Restaurant.modell.Order;
import com.example.Restaurant.modell.Pizza;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class ProductHandling {

    private final Menu menu = new Menu();

    @GetMapping("/product/pizzas")
    public ArrayList<Pizza> getPizzas(){
        return menu.getPizzaList();

    }

}
