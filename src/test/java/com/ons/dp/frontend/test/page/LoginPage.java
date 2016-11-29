package com.ons.dp.frontend.test.page;


import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public By input_email = By.id("email");

    public By getInput_email() {
        return input_email;
    }

    public By getInput_password() {
        return input_password;
    }

    public By getSubmit() {
        return submit;
    }

    public By input_password = By.id("password");
    public By submit = By.id("login");



    public void openLoginPage(){
        navigateToUrl(getConfig().getFlorence_develop());

    }
    public void login(String email, String pwd)
    {   clear(input_email);
        clear(input_password);
        sendKeys(input_email,email);
        sendKeys(input_password,pwd);
        click(submit);
    }
    public void openAndLogin(String email, String pwd){
        openLoginPage();
        login(email, pwd);
    }

 }
