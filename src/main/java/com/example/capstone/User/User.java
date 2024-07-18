// com.example.capstone.User.User.java
package com.example.capstone.User;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "User")
public class User {

    public User(Long userId ,String cID, String cPW, String cName, char cGender, Date cbirthDate, String ctel, String cEmail) {
        this.userId = userId;
        this.cID = cID;
        this.cPW = cPW;
        this.cName = cName;
        this.cGender = cGender;
        this.cbirthDate = cbirthDate;
        this.ctel = ctel;
        this.cEmail = cEmail;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = 20)
    private String cID;

    @Column(nullable = false, length = 20)
    private String cPW;

    @Column(nullable = false, length = 20)
    private String cName;

    @Column(nullable = false, length = 1)
    private char cGender;

    @Column(nullable = false)
    private Date cbirthDate;

    @Column(nullable = false, length = 20)
    private String ctel;

    @Column(length = 20)
    private String cEmail;

    public User() {

    }

    /*
    @Lob
    private byte[] cProfileImage;
    */

    // getters and setters
}