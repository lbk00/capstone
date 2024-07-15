// com.example.capstone.User.User.java
package com.example.capstone.User;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "User")
public class User {

    public User(String cID, String cPW, String cName, char cGender, Date cbirthDate, String ctel, String cEmail) {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public String getcPW() {
        return cPW;
    }

    public void setcPW(String cPW) {
        this.cPW = cPW;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public char getcGender() {
        return cGender;
    }

    public void setcGender(char cGender) {
        this.cGender = cGender;
    }

    public Date getCbirthDate() {
        return cbirthDate;
    }

    public void setCbirthDate(Date cbirthDate) {
        this.cbirthDate = cbirthDate;
    }

    public String getCtel() {
        return ctel;
    }

    public void setCtel(String ctel) {
        this.ctel = ctel;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    /*
    @Lob
    private byte[] cProfileImage;
    */

    // getters and setters
}