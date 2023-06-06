package com.jackbracey.recipeapi.Services;

import com.jackbracey.recipeapi.Entities.UserEntity;
import com.jackbracey.recipeapi.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmailIgnoreCase(email);
        if (userEntity == null)
            throw new UsernameNotFoundException(email);
        return User.withUsername(userEntity.getEmail()).password(userEntity.getPassword())
                .authorities("USER").build();
    }
}
