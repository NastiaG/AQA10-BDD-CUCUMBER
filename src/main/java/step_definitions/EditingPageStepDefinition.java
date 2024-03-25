package step_definitions;

import driver_factory.DriverSetupEdit;
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

public class EditingPageStepDefinition {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final String url = "https://qa-course-01.andersenlab.com";
    private static final String successTitle = "My account";

    @FindBy(xpath = "//input[@name='email']")
    private static WebElement inputEmail;
    @FindBy(xpath = "//input[@name='password']")
    private static WebElement inputPassword;
    @FindBy(xpath = "//button[@type='submit']")
    private static WebElement buttonSubmit;
    @FindBy(xpath = "//a[@href='/editAccount']")
    private static WebElement editLink;
    @FindBy(xpath = "//input[@name='passwordConfirmation']")
    private static WebElement inputPasswordConfirmation;
    @FindBy(xpath = "//p[text() = 'Logout']")
    private static WebElement linkLogout;
    @FindBy(xpath = "//button[@label='Yes']")
    private static WebElement confirmButtonYes;
    @FindBy(xpath = "//h1[@class='text-2xl' and text()='My account']")
    private static WebElement checkSuccessTitle;

    @Given("set up driver for Editing test")
    public void set_up_driver_for_editing_test() {
        driver = DriverSetupEdit.startDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @Given("User is on Log in Page for logging in and further editing")
    public void user_is_on_log_in_page_for_logging_in_and_further_editing() {
        driver.get(url);
    }

    @When("I enter valid email of an already registered user {string}")
    public void i_enter_valid_email_of_an_already_registered_user(String string) {
        wait.until(ExpectedConditions.visibilityOf(inputEmail));
        inputEmail.sendKeys(string);
    }

    @And("I enter valid password of an already registered user {string}")
    public void i_enter_valid_password_of_an_already_registered_user(String string) {
        inputPassword.sendKeys(string);
    }

    @And("I click button Submit to log in")
    public void i_click_button_submit_to_log_in() {
        buttonSubmit.click();
    }

    @And("I click the link Edit account")
    public void i_click_the_link_edit_account() {
        wait.until(ExpectedConditions.visibilityOf(editLink));
        editLink.click();
    }

    @And("I input new password in the field Password {string}")
    public void i_input_new_password_in_the_field_password(String string) {
        inputPassword.sendKeys(string);
    }

    @And("I input the same new password in the field Password Confirmation {string}")
    public void i_input_the_same_new_password_in_the_field_password_confirmation(String string) {
        inputPasswordConfirmation.sendKeys(string);
    }

    @And("I click button Submit to confirm the changing of password")
    public void i_click_button_submit_to_confirm_the_changing_of_password() {
        buttonSubmit.click();
    }

    @And("I click link Logout on Account Page")
    public void i_click_link_logout_on_account_page() {
        wait.until(ExpectedConditions.visibilityOf(linkLogout));
        linkLogout.click();
    }

    @And("I confirm logging out pressing Yes on the alert message")
    public void i_confirm_logging_out_pressing_yes_on_the_alert_message() {
        confirmButtonYes.click();
    }

    @And("I enter new password of an already registered user {string}")
    public void i_enter_new_password_of_an_already_registered_user(String string) {
        inputPassword.sendKeys(string);
    }

    @Then("I see a logged-in Account Page with my name and email after logging in with new password")
    public void i_see_a_logged_in_account_page_with_my_name_and_email_after_logging_in_with_new_password() {
        wait.until(ExpectedConditions.visibilityOf(checkSuccessTitle));
        Assert.assertEquals(checkSuccessTitle.getText(), successTitle);
    }
}