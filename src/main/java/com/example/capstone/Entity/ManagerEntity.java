package com.example.capstone.Entity;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "Manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false)
    private String mID;

    @Column(nullable = false)
    private String mPW;

    @Column(nullable = false)
    private String mName;

    @Column(nullable = false)
    private char mGender;

    @Column(nullable = false)
    private Date mbirthDate;

    @Column(nullable = false)
    private String mtel;

    private String mEmail;

    private Blob mProfileImage;

    @Column(nullable = false)
    private String uAdr;

    // getters and setters
}