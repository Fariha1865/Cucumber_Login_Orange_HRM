import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDefinitions extends Setup{

    LoginPage loginPage = new LoginPage(driver);
    @Given("User visited the portal")
    public void user_visited_the_portal() {
          driver.get("https://opensource-demo.orangehrmlive.com");
    }
    @When("User inputs valid {string} and {string}")
    public void user_inputs_valid_and(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(username,password);


    }
    @Then("User can see dashboard")
    public void user_can_see_dashboard() {

        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("index"));

    }



    @Given("User visited the portal_2")
    public void user_visited_the_portal_2() {
        driver.get("https://opensource-demo.orangehrmlive.com");
    }
    @When("User inputs invalid {string} and {string}")
    public void user_inputs_invalid_and(String username, String password) {


        loginPage.doLogin(username,password);


    }
    @Then("User can see error message")
    public void user_can_see_error_message() {

        String url = driver.getCurrentUrl();
        Assert.assertTrue(loginPage.lblValidationError.getText().contains("Invalid credentials"));

    }

}
