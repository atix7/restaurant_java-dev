package com.example.Restaurant;

import com.example.Restaurant.modell.Pizza;
import com.example.Restaurant.modell.Size;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}
	Pizza p1 = new Pizza("Piedone", 2000, Size.medium);
	Pizza p2 = new Pizza("Margareta", 2000, Size.medium);

}
