package dev.restaurant.app.foodie.controller;

import dev.restaurant.app.foodie.entities.User;
import dev.restaurant.app.foodie.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/foodie/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable(value = "id") Long id) {
        Optional<User> user = userRepo.findById(id);
        if(user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public User addUser(@Validated @RequestBody User user){
        return userRepo.save(user);
    }

}
