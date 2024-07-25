package com.example.capstone.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class UserDTO {

    private Long userId;
    private String cID;
    private String cPW;
    private String cName;
    private char cGender;
    private Date cbirthDate;
    private String ctel;
    private String cEmail;


    // getters and setters
}