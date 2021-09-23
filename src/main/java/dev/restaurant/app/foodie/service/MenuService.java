package dev.restaurant.app.foodie.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.restaurant.app.foodie.dto.MenuDTO;
import dev.restaurant.app.foodie.entities.Menu;
import dev.restaurant.app.foodie.entities.Restaurant;
import dev.restaurant.app.foodie.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MenuService {

    @Autowired
    RestaurantRepo restaurantRepo;

    public String addMenu(MenuDTO menuDTO){
        Menu menu = new ObjectMapper().convertValue(menuDTO,Menu.class);



        return "Menu ID: " + menu.getId();
    }

}
