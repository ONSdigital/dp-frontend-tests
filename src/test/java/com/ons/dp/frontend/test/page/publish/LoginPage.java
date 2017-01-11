package com.ons.dp.frontend.test.page.publish;


import com.ons.dp.frontend.test.page.BasePage;
import com.ons.dp.frontend.test.util.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {

    public By input_email = By.id("email");
    public By input_password = By.id("password");
    public By submit = By.id("login");


    public By getInput_email() {
        return input_email;
    }

    public By getInput_password() {
        return input_password;
    }

    public By getSubmit() {
        return submit;
    }

    public void openLoginPage() {
        navigateToUrl(getConfig().getFlorence_develop());

    }

    public void openErmintrudeLoginPage() {
        navigateToUrl(getConfig().getErmintrude_develop());
    }

    public void login(String email, String pwd) {
        getDriver().manage().deleteAllCookies();
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(input_email));
        clear(input_email);
        clear(input_password);
        sendKeys(input_email, email);
        sendKeys(input_password, pwd);
        // click(submit);
        Helper.pause(1000);
        //getDriver().findElement(By.id("login")).click();
        getDriver().findElement(By.xpath(".//*[@id='login']")).click();
    }

    public void ermintrudeLogin(String email, String pwd) {
        getDriver().manage().deleteAllCookies();
        clear(input_email);
        clear(input_password);
        sendKeys(input_email, email);
        sendKeys(input_password, pwd);
        click(submit);
    }

    public void openAndLogin(String email, String pwd) {
        openLoginPage();
        login(email, pwd);
        if (!getElement(By.linkText("Logout")).isEnabled()) {
            login(email, pwd);
        }
    }

    public void openAndLoginToErmintrude(String email, String pwd) {

        openErmintrudeLoginPage();
        ermintrudeLogin(email, pwd);

    }

    public void goToPage(String linkToGoTo) {
        navigateToUrl(getConfig().getFlorence_preview() + "/" + linkToGoTo);
    }

    public void switchBackToMainTab() {
        getDriver().switchTo().defaultContent();
    }

    public void openAndLoginIntoFlorence(String email, String pwd) {
        openLoginPage();
        login(email, pwd);
    }
}
