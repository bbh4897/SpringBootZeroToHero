package com.burcu.springBootZeroToHero.controller;

import com.burcu.springBootZeroToHero.model.UserModel;
import com.burcu.springBootZeroToHero.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userList")
    public List<UserModel> allUser() {
        return userService.userList();
    }

    @PostMapping("/createUser")
    public UserModel createUser(@RequestBody UserModel userModel) {
        return userService.addUser(userModel);
    }

    @PutMapping("/updateUser/{id}")
    public UserModel updateUser(@PathVariable UUID id, @RequestBody UserModel userModel) {
        return userService.editUser(id, userModel);
    }

    @DeleteMapping("/deleteUser/{id}")
    public UserModel updateUser(@PathVariable UUID id) {
        return userService.deleteUser(id);
    }
}
