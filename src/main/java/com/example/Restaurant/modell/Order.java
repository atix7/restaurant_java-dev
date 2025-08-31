package com.example.Restaurant.modell;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)



public class Order {

    private int orderId;
    static int lastOrderID;
    private ArrayList<Drink> drinks;
    private int numberOfDrinks;
    private int numberOfPizzas;



    private ArrayList<Pizza> pizzas;

    public Order(Drink drink, int numberOfDrinks, Pizza pizza) {
        lastOrderID++;
        this.orderId = lastOrderID;
        this.pizzas = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.pizzas.add(pizza);
        for (int i = 0; i < numberOfDrinks; i++) {
            this.drinks.add(drink);
        }
    }

    public Order() {
        lastOrderID++;
        this.orderId = lastOrderID;
        this.pizzas = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
        numberOfPizzas = pizzas.size();
    }

    public void addDrink(Drink drink){
        drinks.add(drink);
        numberOfDrinks = drinks.size();
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }
    public int getNumberOfPizzas() {
        return numberOfPizzas;
    }

    public void setNumberOfPizzas(int numberOfPizzas) {
        this.numberOfPizzas = numberOfPizzas;
    }
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public int getNumberOfDrinks() {
        return numberOfDrinks;
    }

    public void setNumberOfDrinks(int numberOfDrinks) {
        this.numberOfDrinks = numberOfDrinks;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public double getTotalPrice() {
        double total = 0;
        for (Pizza pizza : pizzas) {
            switch (pizza.getPSize()) {
                case small -> {
                    total += 0.5 * pizza.getPrice();
                }
                case medium -> {
                    total += pizza.getPrice();
                }
                case large -> {
                    total += 1.5 * pizza.getPrice();
                }
            }
        }

        for (Drink d : drinks) {
            total += d.getPrice();
        }
        return total;
    }

}