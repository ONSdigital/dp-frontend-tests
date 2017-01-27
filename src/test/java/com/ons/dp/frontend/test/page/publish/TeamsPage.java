package com.ons.dp.frontend.test.page.publish;

import com.ons.dp.frontend.test.model.DataTable;
import com.ons.dp.frontend.test.page.BasePage;
import com.ons.dp.frontend.test.util.Do;
import com.ons.dp.frontend.test.util.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;


public class TeamsPage extends BasePage {

    public By team_name = By.id("create-team-name");
    public By team_table_id = By.id("collection-name");
    public By confirm_deletion_textbox = By.cssSelector(".sweet-alert.show-input.showSweetAlert.visible>fieldset>input");
    public By confirm_delete_button = By.cssSelector(".confirm");
    public By search_user = By.id("team-search-input");
    public By active_add_button = By.cssSelector(".btn-team-add");

    DataTable dataTable;

    public By getCreateTeam_Button() {
        return getButton(buttonElement, "Create team");
    }

    public void clearForm() {
        clear(team_name);
    }

    public Map<String, WebElement> getTeamData() {
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(team_table_id));
        dataTable = new DataTable(true);
        return dataTable.getLeftData();
    }

    public boolean doesTeamExist(String teamname) {
        boolean elementPresent = false;
        Do.until(getDriver(), ExpectedConditions.presenceOfElementLocated(team_name));
        WebElement webElement = getTeamData().get(teamname);
        if (webElement != null) {
            elementPresent = true;
            webElement.click();
        }
        return elementPresent;
    }

    public void goToTeamsPage() {
        refresh();
        click(getlinkText("Teams"));
        Do.until(getDriver(), ExpectedConditions.presenceOfElementLocated(team_table_id));
        refresh();
        click(getlinkText("Teams"));

    }

    public void createTeam(String teamName) {
        // clearForm();
        sendKeys(team_name, teamName);
        click(getButton(buttonElement, "Create team"));


    }

    public void deleteTeam(String teamname) {
        getTeamData().get(teamname).click();
        click(getButton(buttonElement, "Delete team"));
        Helper.pause(1000);
        sendKeys(confirm_deletion_textbox, teamname);
        Helper.pause(2000);
        getElement(confirm_delete_button).click();
        Helper.pause(1000);
        getElement(confirm_delete_button).click();

    }


    public boolean doesTheTeamNameExist(String teamname) {
        refresh();
        click(By.linkText("Teams"));
        return doesTeamExist(teamname);

    }

    public void addUserToTheTeam(String userEmail) {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(getButton(buttonElement, "Add/remove members")));
        click(getButton(buttonElement, "Add/remove members"));

        sendKeys(search_user, userEmail);
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(getButton(buttonElement, "Add")));
        getElement(active_add_button).click();
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(getButton(buttonElement, "Done")));
        click(getButton(buttonElement, "Done"));


    }
}
