package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.page.LoginPage;
import cucumber.api.java.en.Given;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Given("I login as user: (.*) and password (.*)$")
    public void loginUser(String username, String pwd){
        loginPage.openAndLogin(username,pwd);
    }
    @Given("I am logged in as an admin$")
    public void adminLogin(){
        //       loginPage.openAndLogin("testuser@test.com","one two three four");
        loginPage.openAndLogin("florence@magicroundabout.ons.gov.uk", "one two three four");
    }
    @Given("I am logged in as a publisher$")
    public void publisherLogin(){
        loginPage.openAndLogin("publisher@test.com","one two three four");
    }

    @Given("I am logged in as a lead publisher$")
    public void leadPublisherLogin() {
        loginPage.openAndLogin("publisher2@test.com", "one two three four");
    }

}
