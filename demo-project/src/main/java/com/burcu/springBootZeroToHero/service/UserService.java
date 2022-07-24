package com.burcu.springBootZeroToHero.service;

import com.burcu.springBootZeroToHero.exception.UserNotFoundException;
import com.burcu.springBootZeroToHero.model.UserModel;
import com.burcu.springBootZeroToHero.repository.UserRepository;
import com.burcu.springBootZeroToHero.request.CreateUserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> userList() {
        return userRepository.findAll();
    }

    public UserModel addUser(CreateUserRequest userRequest) {
        UserModel userModel = new UserModel();
        userModel.setUserName(userRequest.getUserName());
        userModel.setPassword(userRequest.getPassword());
        userModel.setEmail(userRequest.getEmail());
        return userRepository.save(userModel);
    }

    public UserModel editUser(UUID id, UserModel userModel) {
        UserModel user = userRepository.findUserModelById(id)
                .orElseThrow(UserNotFoundException::new);

        user.setUserName(userModel.getUserName());
        user.setPassword(userModel.getPassword());
        user.setEmail(userModel.getEmail());

        return userRepository.save(user);
    }

    public void deleteUser(UUID id) {
        UserModel user = userRepository.findUserModelById(id)
                .orElseThrow(UserNotFoundException::new);

         userRepository.delete(user);
    }

    public UserModel getUser(UUID id) {
        return userRepository.findUserModelById(id)
                .orElseThrow(UserNotFoundException::new);
    }
}
