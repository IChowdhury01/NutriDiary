package me.ichowdhury.nutridiary.controller;

import me.ichowdhury.nutridiary.model.Log;
import me.ichowdhury.nutridiary.model.User;
import me.ichowdhury.nutridiary.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController // This class uses the Spring REST API to handle HTTP requests
@RequestMapping("/api") // Wait  for an HTTP request at /api
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    // Read users from database
    @GetMapping("/users")   // Wait for a get request at /api/users. Then invoke displayUsers()
    Collection<User> displayUsers() {
        return userRepository.findAll();    // Retrieve all users from the database, and display them as JSONs.
    }

    @GetMapping("/user/{id}")   // api/users/user_id
    ResponseEntity<?> displayUserByID(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create user and store in database
    @PostMapping("/user")    // /api/user
    ResponseEntity<User> createUser(@Valid @RequestBody User user) throws URISyntaxException {
        user = parseUserInfo(user);
        User newUser = userRepository.save(user); // Save new user into database table.
        return ResponseEntity.created(new URI("/api/user" + newUser.getId())).body(newUser);   // Create and send HTTP response entity out of user object.
    }

    // Update user data in database
    @PutMapping("/user/{id}")    // /api/user/user_id
    ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
        user = parseUserInfo(user);
        User updatedUser = userRepository.save(user);   // Update database with user object.
        return ResponseEntity.ok().body(updatedUser);
    }

    // Delete user from database
    @DeleteMapping("/user/{id}")
    ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);   // Delete user from database.
        return ResponseEntity.ok().build();
    }

    // Edit new user data before inserting into database.
    private static User parseUserInfo(User user) {
        // Set default profile picture path if none was entered.
        if(user.getProfilePic().isEmpty() || user.getProfilePic().isBlank()) {
            user.setProfilePic("/images/blank-profile.png");    // Set default profile picture URL.
        }

        // Insert password hashing algorithm here
        return user;
    }
}
