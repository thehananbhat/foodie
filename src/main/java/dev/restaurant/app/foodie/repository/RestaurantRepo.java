package dev.restaurant.app.foodie.repository;

import dev.restaurant.app.foodie.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {

}
