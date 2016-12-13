package com.ons.dp.frontend.test.page.publish;

import com.ons.dp.frontend.test.model.ContentText;
import com.ons.dp.frontend.test.model.DataTable;
import com.ons.dp.frontend.test.page.BasePage;
import com.ons.dp.frontend.test.util.Do;
import com.ons.dp.frontend.test.util.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

/**
 * Created by admin on 08/12/2016.
 */
public class TeamsPage extends BasePage {

    public By team_name = By.id("create-team-name");
    public By confirm_deletion_textbox = By.cssSelector(".sweet-alert.show-input.showSweetAlert.visible>fieldset>input");
    public By confirm_delete_button = By.cssSelector(".confirm");

    DataTable dataTable;

    public By getCreateTeam_Button() {
        return getButton(buttonElement, "Create team");
    }

    public void clearForm() {
        clear(team_name);
    }

    public Map<String, WebElement> getLeftTableContents() {
        dataTable = new DataTable(true);
        return dataTable.getLeftData();
    }

    public void goToTeamsPage() {
        click(getlinkText("Teams"));
        Do.until(getDriver(), ExpectedConditions.presenceOfElementLocated(team_name));
        //  dataTable= new DataTable(false);
    }

    public void createTeam(String teamName) {
        clearForm();
        sendKeys(team_name, teamName);
        click(getButton(buttonElement, "Create team"));

    }

    public void deleteTeam(String teamname) {
        getLeftTableContents().get(teamname).click();
        click(getButton(buttonElement, "Delete team"));
        Helper.pause(1000);
        sendKeys(confirm_deletion_textbox, teamname);
        Helper.pause(2000);
        getElement(confirm_delete_button).click();
        Helper.pause(1000);
        getElement(confirm_delete_button).click();

    }


    public boolean doesTheTeamNameExists(String teamname) {
        refresh();
        click(By.linkText("Teams"));
        return getLeftTableContents().get(teamname).getText().equals(teamname) ? true : false;

    }

}
