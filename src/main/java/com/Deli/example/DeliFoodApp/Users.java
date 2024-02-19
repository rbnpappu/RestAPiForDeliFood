package com.Deli.example.DeliFoodApp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "userName")
    private String userName;
    
    @Column(name = "userEmail")
    private String userEmail;
    
    @Column(name = "contactInfo")
    private String contactInfo;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "retypePassword")
    private String retypePassword;

    // Default constructor
    public Users() {
        // Initialize any default values if needed
    }

    // Getters and setters

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", userEmail=" + userEmail + ", contactInfo=" + contactInfo
                + ", password=" + password + ", retypePassword=" + retypePassword + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }
}
