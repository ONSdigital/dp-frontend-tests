package stepDefs.florence;

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
        loginPage.openAndLogin("testuser@test.com","one two three four");
    }

}
