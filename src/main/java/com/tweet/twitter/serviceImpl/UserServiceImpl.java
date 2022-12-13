package com.tweet.twitter.serviceImpl;

import com.tweet.twitter.dtos.RegisterDto;
import com.tweet.twitter.exception.EmailAlreadyTakenException;
import com.tweet.twitter.models.Role;
import com.tweet.twitter.models.User;
import com.tweet.twitter.repositories.RoleRepository;
import com.tweet.twitter.repositories.UserRepository;
import com.tweet.twitter.services.UserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public User registerUser(RegisterDto registerDto)  {
        User user = new User();
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setEmail(registerDto.getEmail());
        user.setDateOfBirth(registerDto.getDateOfBirth());
        String name = user.getFirstName() + user.getLastName();
        boolean nameTaken = true;
        String tempName = "";

        while(nameTaken){
            tempName = generateUsername(name);
            if(userRepository.findByUsername(tempName).isEmpty()){
                nameTaken = false;
            }
        }
        user.setUsername(tempName);


        Set<Role> roles = new HashSet<>(); //initializes in this method, to create an empty role
       // Set<Role> roles = user.getAuthorities(); //initialized in the field, creates an empty role
        //if not initialized, it sets to null, null diff from empty.
        roles.add(roleRepository.findRoleByAuthority("USER").get());
        user.setAuthorities(roles);

        try{
            return userRepository.save(user);
        }catch(Exception e){
            throw new EmailAlreadyTakenException();
        }


    }

    private String generateUsername(String name){
        long generatedNumber = (long)Math.floor(Math.random() * 1_000_000);
        return name + generatedNumber;

    }
}
