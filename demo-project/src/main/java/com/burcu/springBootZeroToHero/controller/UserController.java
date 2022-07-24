package com.burcu.springBootZeroToHero.controller;

import com.burcu.springBootZeroToHero.model.UserModel;
import com.burcu.springBootZeroToHero.request.CreateUserRequest;
import com.burcu.springBootZeroToHero.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@Validated
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
    public UserModel createUser(@Valid @RequestBody CreateUserRequest userRequest) {
        return userService.addUser(userRequest);
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
    public UserModel getUser(UUID id) {
       return  userService.getUser(id);
    }
}
