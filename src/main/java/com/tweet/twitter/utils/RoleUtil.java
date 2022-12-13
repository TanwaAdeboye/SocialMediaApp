package com.tweet.twitter.utils;

import com.tweet.twitter.models.Role;
import com.tweet.twitter.repositories.RoleRepository;
import com.tweet.twitter.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleUtil {

    @Bean
    CommandLineRunner run(RoleRepository roleRepository, UserService userService)
    {
        return args -> {
            roleRepository.save(new Role(1, "USER"));
            roleRepository.save(new Role(2,"ADMIN"));
//            User user = new User();
//            user.setFirstName("Dorcas");
//            user.setLastName("Queen");
//            userService.registerUser(user);

        };
    }
}
