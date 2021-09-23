package dev.restaurant.app.foodie.controller;

import dev.restaurant.app.foodie.entities.Restaurant;
import dev.restaurant.app.foodie.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/foodie/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantRepo restaurantRepo;

    @GetMapping("/")
    public List<Restaurant> findAllRestaurants(){
        return restaurantRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findRestaurantByName(@PathVariable(value = "id") Long id) {
        Optional<Restaurant> restaurant = restaurantRepo.findById(id);
        if(restaurant.isPresent()) {
            return ResponseEntity.ok().body(restaurant.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public Restaurant restaurant(@Validated @RequestBody Restaurant restaurant){
        return restaurantRepo.save(restaurant);
    }


}
