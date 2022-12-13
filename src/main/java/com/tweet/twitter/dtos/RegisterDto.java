package com.tweet.twitter.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterDto {
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
}
