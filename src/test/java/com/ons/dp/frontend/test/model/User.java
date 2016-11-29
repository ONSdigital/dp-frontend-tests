package com.ons.dp.frontend.test.model;

public class User {
    public User(){

    }
    public User(String username, String email, String password, UserType userType){
        setUsername(username);
        setEmail(email);
        setPassword(password);
        setUserType(userType);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    private String username, email, password;
    private UserType userType;

    public enum UserType {
        Administrator, Publisher, Visualisation_Publisher,Viewer;
    }

}
