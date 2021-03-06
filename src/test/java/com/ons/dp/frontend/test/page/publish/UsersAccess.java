package com.ons.dp.frontend.test.page.publish;

import com.ons.dp.frontend.test.model.DataTable;
import com.ons.dp.frontend.test.model.User;
import com.ons.dp.frontend.test.page.BasePage;
import com.ons.dp.frontend.test.util.Do;
import com.ons.dp.frontend.test.util.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class UsersAccess extends BasePage {


    public By create_username = By.id("create-user-username");
    public By create_email = By.id("create-user-email");
    public By create_pwd = By.id("create-user-password");
    public By type_viewer = By.id("viewer-type");
    public By type_admin = By.id("admin-type");
    public By type_publisher = By.id("publisher-type");
    public By type_visualisation_publisher = By.id("data-vis-type");
    public By label_select_user = By.cssSelector(".collection-name");
    public By confirm_ok = By.className("confirm");
    public By user_created_label = By.xpath("//h2[text()[contains(.,'User created')]]");
    public By confirm_email_deletion = By.xpath("html/body/div[5]/fieldset/input");
    public By confirm_user_deletion = By.cssSelector(".confirm");
    DataTable dataTable;

    public By getCreate_UserName_Button() {
        return getButton(buttonElement, "Create user");
    }

    public By getDeleteUser_Button() {
        return getButton(buttonElement, "Delete user");
    }

    public By getChange_Pwd_Button() {
        return getButton(buttonElement, "Change password");
    }

    public By getCancel_Button() {
        return getButton(buttonElement, "Cancel");
    }

    public By getConfirmDelete() {
        return getButton(buttonElement, "Delete");
    }

    public Map<String, WebElement> getLeftTableContents() {
        dataTable = new DataTable(false);
        return dataTable.getLeftData();
    }

    public Map<String, WebElement> getRightTableContents() {
        if (dataTable == null) {
            dataTable = new DataTable(false);
        }
        return dataTable.getRightData();
    }

    public Map<String, String> getTableContents() {
        return dataTable.getTableContents();
    }


    public void clearForm() {
        clear(create_username);
        clear(create_email);
        clear(create_pwd);
    }

    public void goToUsersAndAccessPage() {
        refresh();
        click(getlinkText("Users and access"));
        Do.until(getDriver(), ExpectedConditions.presenceOfElementLocated(label_select_user));
        refresh();
        click(getlinkText("Users and access"));
        dataTable = new DataTable(false);
    }

    public void createUser(User createUser, String userType) {
        //clearForm();
        sendKeys(create_username, createUser.getUsername());
        sendKeys(create_email, createUser.getEmail());
        sendKeys(create_pwd, createUser.getPassword());
        switch (userType) {
            case "Administrator":
                click(type_admin);
                break;
            case "Publisher":
                click(type_publisher);
                break;
            case "Visualisation_Publisher":
                click(type_visualisation_publisher);
                break;
            case "Viewer":
                click(type_viewer);
                break;
            default:
                System.out.println("Type not available");

        }
        click(getCreate_UserName_Button());


    }

    public void checkCreateNewUserConfirmation() {
        getElementText(user_created_label);
        click(confirm_ok);
    }

    public Map getUserNames() {
        return getLeftTableContents();
    }

    public Map getEmailAddresses() {
        return getRightTableContents();
    }

    public boolean doesTheUserNameExists(String username) {
        refresh();
        click(By.linkText("Users and access"));
        return (getUserNames().get(username) != null);

    }

    public boolean doesEmailExists(String email) {
        refresh();
        click(By.linkText("Users and access"));
        return (getEmailAddresses().get(email) != null);

    }

    public String returnEmailForUser(String username) {
        return getTableContents().get(username);
    }

    public void deleteUser(String username) {
        getLeftTableContents().get(username).click();
        Helper.pause(1000);
        click(getDeleteUser_Button());
        String getEMail = returnEmailForUser(username);
        sendKeys(confirm_email_deletion, getEMail);
        Helper.pause(500);
        click(confirm_user_deletion);
        Helper.pause(1000);


    }

}
