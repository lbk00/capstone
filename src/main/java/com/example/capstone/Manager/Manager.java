// com.example.capstone.manager.Manager.java
package com.example.capstone.Manager;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = 20)
    private String mID;

    @Column(nullable = false, length = 20)
    private String mPW;

    @Column(nullable = false, length = 20)
    private String mName;

    @Column(nullable = false, length = 1)
    private char mGender;

    @Column(nullable = false)
    private Date mbirthDate;

    @Column(nullable = false, length = 20)
    private String mtel;

    @Column(length = 20)
    private String mEmail;

    @Lob
    private byte[] mProfileImage;

    @Column(nullable = false, length = 20)
    private String uAdr;

    // getters and setters
}