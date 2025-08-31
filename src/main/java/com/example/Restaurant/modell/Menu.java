package com.example.Restaurant.modell;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Getter
@Setter

public  class Menu {
    private ArrayList<Pizza> pizzaList = new ArrayList<>();
    private List<Drink> drinkList = new ArrayList<>();

    public Menu() {
        Pizza p1 = new Pizza("Piedone", 2000, Size.medium);
        Pizza p2 = new Pizza("Margareta", 1000, Size.medium);
        Pizza p3 = new Pizza("Quatro formaggi", 1500, Size.medium);
        this.pizzaList.add(0,p1);
        this.pizzaList.add(1,p2);
        this.pizzaList.add(2,p3);

        Drink d1 =new Drink("water",750,500);
        Drink d2 =new Drink("tea",600,300);
        this.drinkList.add(0,d1);
        this.drinkList.add(1,d2);
    }

    public Pizza getPizzaByID(int pizzaId){
        return pizzaList.get(pizzaId);
    }

    public Drink getDrinksByID(int drinksId){
        return drinkList.get(drinksId);
    }

}
