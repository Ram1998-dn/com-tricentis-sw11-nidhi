package testsuite;

/**
 * Create the package ‘testsuite’ and create the
 * following classes inside the ‘testsuite’ package.
 * 1. LoginTest
 * 2. TopMenuTest
 * 3. RegisterTest
 *Write down the following test in the ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully()
 * * click on the ‘Login’ link
 * * Verify the text ‘Welcome, Please Sign
 * In!’
 * 2. userShouldLoginSuccessfullyWithValidCredentials()
 * * click on the ‘Login’ link
 * * Enter a valid username
 * * Enter a valid password
 * * Click on the ‘Login’ button
 * * Verify the ‘Welcome to our store’
 * text is displayed
 * 3. verifyTheErrorMessage()
 * * click on the ‘Login’ link
 * * Enter the invalid username
 * * Enter the invalid password
 * * Click on the ‘Login’ button
 * * Verify the error message ‘Login was unsuccessful.
 * Please correct the errors and try again. No customer account found’
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    String baseUrl = "https://demowebshop.tricentis.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // Click on the 'Login' link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        // Verify the text 'Welcome, Please Sign In!'
        WebElement welcomeText = driver.findElement(By.xpath("//h1[contains(text()='Welcome, Please Sign In!']"));
        assertEquals("Welcome, Please Sign In!", welcomeText.getText());
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Click on the 'Login' link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        //  Find Email Field Element ID Locator
        WebElement emailField = driver.findElement(By.name("Email"));
        emailField.sendKeys("nn24@gmail.com");

        //Find Password Field Element Using name Locator
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("8$Meqe!d!eGpf");

        //Find and click the login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value = 'Log in']"));
        //WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();

        // Verify the text 'Welcome, Please Sign In!'
        WebElement welcomeMessage = driver.findElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        assertTrue(welcomeMessage.isDisplayed());


    }

    @Test
    public void verifyTheErrorMessage() {
        // Click on the 'Login' link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        WebElement emailId = driver.findElement(By.id("Email"));
        emailId.sendKeys("nn23@ggg.com");

        WebElement passwordId = driver.findElement(By.id("Password"));
        emailId.sendKeys("45hhhhf");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value= 'Log in']"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(class,validation-summary-errors))]"));
        String expectedErrorMessage = "Login was unsuccessful.\n" +
                "Please correct the errors and try again. No customer account found";
        assertEquals(expectedErrorMessage, errorMessage.getText());

    }


    @After
    public void tearDown() {
         closeBrowser();
    }


}
