package com.example.capstone.User;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class UserDTO {
    public UserDTO(Long userId, String cID, String cPW, String cName, char cGender, Date cbirthDate, String ctel, String cEmail) {
        this.userId = userId;
        this.cID = cID;
        this.cPW = cPW;
        this.cName = cName;
        this.cGender = cGender;
        this.cbirthDate = cbirthDate;
        this.ctel = ctel;
        this.cEmail = cEmail;
    }

    private Long userId;
    private String cID;
    private String cPW;
    private String cName;
    private char cGender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date cbirthDate;
    private String ctel;
    private String cEmail;


    public static UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO(
                user.getUserId(),
                user.getCID(),
                user.getCPW(),
                user.getCName(),
                user.getCGender(),
                user.getCbirthDate(),
                user.getCtel(),
                user.getCEmail()
        );

        return userDTO;
    }


    //비밀번호가 같은지 비교해주는 메서드
    public boolean checkPassword(String pw) {
        return this.cPW.equals(pw);
    }

    // getters and setters
}