package com.tweet.twitter;

import com.tweet.twitter.models.Role;
import com.tweet.twitter.models.User;
import com.tweet.twitter.repositories.RoleRepository;
import com.tweet.twitter.repositories.UserRepository;
import com.tweet.twitter.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwitterApplication {

    public static void main(String[] args) {

        SpringApplication.run(TwitterApplication.class, args);
    }

}
