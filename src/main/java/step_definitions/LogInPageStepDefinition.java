package step_definitions;

import driver_factory.DriverSetupLogin;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;


public class LogInPageStepDefinition {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String url = "https://qa-course-01.andersenlab.com";
    private static final String resultErrorMessage = "Required";
    @FindBy(xpath = "//input[@name='email']")
    private static WebElement inputEmail;
    @FindBy(xpath = "//input[@name='password']")
    private static WebElement inputPassword;
    @FindBy(xpath = "//button[@type='submit']")
    private static WebElement buttonSubmit;
    @FindBy(xpath = "//*[contains(text(), 'Required')]")
    private static WebElement errorMessageRequired;

    @Given("set up driver for Login test")
    public void set_up_driver_for_login_test() {
        driver = DriverSetupLogin.startDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @After
    public void closeDriver() {
        // Закрытие драйвера после каждого сценария
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("User is on Log in Page for logging in")
    public void user_is_on_login_page() {
        driver.get(url);
    }

    @When("I don't enter any data in Email field {string}")
    public void i_dont_enter_any_data_in_email_field(String string) {
        wait.until(ExpectedConditions.visibilityOf(inputEmail));
        inputEmail.sendKeys(string);
    }

    @And("I don't enter any data in Password field {string}")
    public void i_dont_enter_any_data_in_password_field(String string) {
        inputPassword.sendKeys(string);
    }

    @And("I click button Sign In")
    public void i_click_button_sign_in() {
        buttonSubmit.click();
    }

    @Then("I see an error message")
    public void i_see_an_error_message() {
        wait.until(ExpectedConditions.visibilityOf(errorMessageRequired));
        Assert.assertEquals(errorMessageRequired.getText(), resultErrorMessage);
    }
}