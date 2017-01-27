package com.ons.dp.frontend.test.model;

public class User {

    private String username, email, password, usertype;

    public User(String username, String email, String password, String userType) {
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

    public String getUserType() {
        return usertype;
    }

    public void setUserType(String usertype) {
        this.usertype = usertype;
    }


}
