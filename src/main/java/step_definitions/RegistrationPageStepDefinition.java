package step_definitions;

import driver_factory.DriverSetupReg;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class RegistrationPageStepDefinition {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private static final String url = "https://qa-course-01.andersenlab.com";
    private static final String successTitle = "My account";
    @FindBy(xpath = "//a[@href='/registration']")
    private static WebElement registrationButton;
    @FindBy(xpath = "//input[@name='firstName']")
    private static WebElement inputFirstName;
    @FindBy(xpath = "//input[@name='lastName']")
    private static WebElement inputLastName;
    @FindBy(xpath = "//input[@name='dateOfBirth']")
    private static WebElement inputDateOfBirth;
    @FindBy(xpath = "//input[@name='email']")
    private static WebElement inputEmail;
    @FindBy(xpath = "//input[@name='password']")
    private static WebElement inputPassword;
    @FindBy(xpath = "//input[@name='passwordConfirmation']")
    private static WebElement inputPasswordConfirmation;
    @FindBy(xpath = "//button[@type='submit']")
    private static WebElement buttonSubmit;
    @FindBy(xpath = "//h1[@class='text-2xl' and text()='My account']")
    private static WebElement checkSuccessTitle;


    @Given("set up driver for Registration test")
    public void set_up_driver_for_reg_test() {
        driver = DriverSetupReg.startDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @Given("User is on Log in Page")
    public void user_is_on_registration_page() {
        driver.get(url);
    }

    @When("I click button Registration")
    public void i_click_button_registration() {
        registrationButton.click();
    }

    @And("I enter first name in the field First Name {string}")
    public void i_enter_first_name_in_the_field_first_name(String string) {
        wait.until(ExpectedConditions.visibilityOf(inputFirstName));
        inputFirstName.sendKeys(string);
    }

    @And("I enter last name in the field Last Name {string}")
    public void i_enter_last_name_in_the_field_last_name(String string) {
        inputLastName.sendKeys(string);
    }

    @And("I input date of birth in the field Date of Birth {string}")
    public void i_input_date_of_birth_in_the_field_date_of_birth(String string) {
        inputDateOfBirth.sendKeys(string);
        actions.keyDown(Keys.TAB);
    }

    @And("I input email in the field Email {string}")
    public void i_input_email_in_the_field_email(String string) {
        wait.until(ExpectedConditions.visibilityOf(inputEmail));
        inputEmail.sendKeys(string);
    }

    @And("I input password in the field Password {string}")
    public void i_input_password_in_the_field_password(String string) {
        inputPassword.sendKeys(string);
    }

    @And("I input the same password in the field Password Confirmation {string}")
    public void i_input_the_same_password_in_the_field_password_confirmation(String string) {
        inputPasswordConfirmation.sendKeys(string);
    }

    @And("I click button Submit")
    public void i_click_button_submit() {
        buttonSubmit.click();
    }

    @Then("I see a logged-in Account Page with my name and email")
    public void i_see_a_logged_in_account_page_with_my_name_and_email() {
        wait.until(ExpectedConditions.visibilityOf(checkSuccessTitle));
        Assert.assertEquals(checkSuccessTitle.getText(), successTitle);
    }
}