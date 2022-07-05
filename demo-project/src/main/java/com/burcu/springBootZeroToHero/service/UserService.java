package com.burcu.springBootZeroToHero.service;

import com.burcu.springBootZeroToHero.model.UserModel;
import com.burcu.springBootZeroToHero.repository.UserRepository;
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

    public UserModel addUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public UserModel editUser(UUID id, UserModel userModel) {
        UserModel userDB = userRepository.getById(id);
        if(userDB != null && id == userDB.getId()) {
            userDB.setUserName(userModel.getUserName());
            userDB.setEmail(userModel.getEmail());
            userDB.setPassword(userModel.getPassword());
            userRepository.save(userDB);
        }
        return userDB;
    }

    public UserModel deleteUser(UUID id) {
        UserModel userDB = userRepository.getById(id);
        if(userDB != null) {
            userRepository.delete(userDB);
        }
        return userDB;
    }
}
