    package com.ons.dp.frontend.test.page;

    import com.ons.dp.frontend.test.model.DataTable;
    import com.ons.dp.frontend.test.model.User;
    import com.ons.dp.frontend.test.util.Do;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.ui.ExpectedConditions;

    import java.util.Map;

    public class UsersAccess extends BasePage {

            public By  create_username = By.id("create-user-username");
            public By  create_email    = By.id("create-user-email");
            public By  create_pwd      = By.id("create-user-password");
            public By  type_viewer     = By.id("viewer-type");
            public By  type_admin      = By.id("admin-type");
            public By  type_publisher  = By.id("publisher-type");
            public By  type_visualisation_publisher = By.id("data-vis-type");
            public String buttonElement = "//button[text()[contains(.,'replace')]]";
            public By  label_select_user = By.className(".collection-name");
            public By getCreate_UserName_Button(){
                   return getButton(buttonElement,"Create user");
            }
            public By getDeleteUser_Button(){
                    return getButton(buttonElement,"Delete user");
            }
            public By getChange_Pwd_Button(){
                return getButton(buttonElement,"Change password");
            }
            public By getCancel_Button(){
                 return getButton(buttonElement,"Cancel");
            }
            public By getConfirmDelete(){
                return getButton(buttonElement,"Delete");
            }
            public By confirm_email_deletion =  By.xpath("//input[@type='text']");
            public By user_access_link = By.linkText("Users and access");
            public Map<String, WebElement> getTableContents(){
                return new DataTable().getCollection();
            }

            public void clearForm(){
                clear(create_username);
                clear(create_email);
                clear(create_pwd);
            }
            public void goToUsersAndAccessPage(){
                 click(user_access_link);
            }
            public void createUser(User createUser){
                clearForm();
                sendKeys(create_username,createUser.getUsername());
                sendKeys(create_email,createUser.getEmail());
                sendKeys(create_pwd, createUser.getPassword());
                switch (createUser.getUserType()){
                    case  Administrator:
                        click(type_admin);
                        break;
                    case Publisher:
                        click(type_publisher);
                        break;
                    case Visualisation_Publisher:
                        click(type_visualisation_publisher);
                        break;
                    case Viewer:
                        click(type_viewer);
                        break;
                    default:
                        System.out.println("Type not available");

                }
                click(getCreate_UserName_Button());

            }
            public boolean doesTheUserExistOnTheList(String username){
              return  (getTableContents().get(username)!= null) ?  true : false;

            }

    /*
            public By  "Select a team", ".table.table--primary.table--fixed-height-27.js-selectable-table");

            public By  "Delete team", ".btn.btn--warning.btn-team-delete");

            public By  "Delete collection", "#collection-delete");
    */
    }
