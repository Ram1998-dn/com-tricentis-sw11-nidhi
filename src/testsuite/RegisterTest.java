package testsuite;
/**
 * Write down the following test in the ‘RegisterTest’
 * class
 * 1. userShouldNavigateToRegisterPageSuccessfully()
 * * click on the ‘Register’ link
 * * Verify the text ‘Register’
 * 2. userSholdRegisterAccountSuccessfully
 * * click on the ‘Register’ link
 * * Select the gender radio button
 * * Enter the First name
 * * Enter the Last name
 * * Enter Email address
 * * Enter Password
 * * Enter Confirm password
 * * Click on the ‘Register’ button
 * * Verify the text 'Your registration completed’
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demowebshop.tricentis.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        // Click on the 'Register' link
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        // Verify the text 'Register'
        WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("Register", pageTitle.getText());
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        // Click on Register link
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        // Select the gender radio button (e.g., Male)
        WebElement genderRadioButton = driver.findElement(By.id("gender-male"));
        genderRadioButton.click();


        WebElement firstNameField = driver.findElement(By.id("FirstName"));
        firstNameField.sendKeys("nn");

        WebElement lastNameField = driver.findElement(By.id("LastName"));
        lastNameField.sendKeys("dd");

        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("nnd245@gmail.com");

        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("8$Meqe!d!eGpfzf");

        WebElement confirmPass = driver.findElement(By.id("ConfirmPassword"));
        confirmPass.sendKeys("8$Meqe!d!eGpfzf");

        WebElement registerPage = driver.findElement(By.id("register-button"));
        registerPage.click();

        WebElement resultMessage = driver.findElement(By.className("result"));
        Assert.assertTrue(resultMessage.isDisplayed());

        // Verify the text 'Your registration completed'
        WebElement confirmationMessage = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("Your registration completed", confirmationMessage.getText());
    }

    @After
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
