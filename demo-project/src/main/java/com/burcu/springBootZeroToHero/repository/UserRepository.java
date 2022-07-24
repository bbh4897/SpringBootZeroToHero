package com.burcu.springBootZeroToHero.repository;


import com.burcu.springBootZeroToHero.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    Optional<UserModel> findUserModelById(UUID id);
}
