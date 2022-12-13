package com.tweet.twitter.services;

import com.tweet.twitter.dtos.RegisterDto;
import com.tweet.twitter.models.User;

public interface UserService {


    User registerUser(RegisterDto registerDto);
}
