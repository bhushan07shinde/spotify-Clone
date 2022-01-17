package com.example.spotify.Model;

public class Users
{
    String email,password,userName,userId;

    public Users(String email, String password, String userName) {
        this.email = email;
        this.password = password;
        this.userName = userName;

    }

    public Users(){}


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
