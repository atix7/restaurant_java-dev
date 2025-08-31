package com.example.Restaurant.modell;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pizza {
    private String name;
    private int price;
    private Size pSize;
    //private Recepies recepie;
    private static int numberOfPizzas=0;

    public Pizza(String name, int price, Size pSize) {
        this.name = name;
        this.price = price;
        this.pSize = pSize;
        numberOfPizzas++;
    }
}
