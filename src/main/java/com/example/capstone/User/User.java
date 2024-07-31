// com.example.capstone.User.User.java
package com.example.capstone.User;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = 20)
    private String cID;

    @Column(nullable = false, length = 20)
    private String cPW;

    @Column(nullable = false, length = 20)
    private String cName;

    @Column(nullable = true, length = 1)
    private char cGender;

    @Column(nullable = true)
    private Date cbirthDate;

    @Column(nullable = false, length = 20)
    private String ctel;

    @Column(length = 20)
    private String cEmail;




    /*
    @Lob
    private byte[] cProfileImage;
    */

    // getters and setters
}