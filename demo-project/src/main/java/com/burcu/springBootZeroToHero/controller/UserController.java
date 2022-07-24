package com.burcu.springBootZeroToHero.controller;

import com.burcu.springBootZeroToHero.model.UserModel;
import com.burcu.springBootZeroToHero.service.UserService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel> allUser() {
        return userService.userList();
    }

    @PostMapping
    public UserModel createUser(@RequestBody UserModel userModel) {
        return userService.addUser(userModel);
    }

    @PutMapping("/{id}")
    public UserModel updateUser(@PathVariable UUID id, @RequestBody UserModel userModel) {
        return userService.editUser(id, userModel);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
         userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public void getUserByID(UUID id) {
        // TODO: To be return
    }
}
