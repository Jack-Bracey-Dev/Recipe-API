package com.jackbracey.recipeapi.Repositories;

import com.jackbracey.recipeapi.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByEmailIgnoreCase(String email);
}
