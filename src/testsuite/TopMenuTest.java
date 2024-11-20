package testsuite;
/**
 * Write down the following test in the ‘TopMenuTest’
 * class
 * 1. userShouldNavigateToComputerPageSuccessfully()
 * * click on the ‘COMPUTERS’ Tab
 * * Verify the text ‘Computers’
 * 2. userShouldNavigateToElectronicsPageSuccessfully()
 * * click on the ‘ELECTRONICS’ Tab
 * * Verify the text ‘Electronics’
 * 3. userShouldNavigateToApparelAndShoesPage
 * Successfully()
 * * click on the ‘APPAREL & SHOES’ Tab
 * * Verify the text ‘Apparel & Shoes’
 * 4.
 * userShouldNavigateToDigitalDownloadsPageSuccessfully()
 * * click on the ‘DIGITAL DOWNLOADS’ Tab
 * * Verify the text ‘Digital downloads’
 * 5. userShouldNavigateToBooksPageSuccessfully()
 * * click on the ‘BOOKS’ Tab
 * * Verify the text ‘Books’
 * 6. userShouldNavigateToJewelryPageSuccessfully()
 * * click on the ‘JEWELRY’ Tab
 * * Verify the text ‘Jewelry’
 * 7. userShouldNavigateToGiftCardsPageSuccessfully()
 * * click on the ‘GIFT CARDS’ Tab
 * * Verify the text ‘Gift Cards’
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {

    String baseUrl = "https://demowebshop.tricentis.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }


    @Test
    public void userShouldNavigateToComputerPageSuccessfully(){
        // Check if the "Computers" link exists in the top menu and click it
        WebElement computersMenu = driver.findElement(By.linkText("Computers"));
        computersMenu.click();

        // Verify that we navigated to the "Computers" page
        WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(text(),'Computers')]"));
        pageTitle.click();
    }
    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        // Click on the 'ELECTRONICS' Tab
        WebElement electronicsTab = driver.findElement(By.linkText("Electronics"));
        electronicsTab.click();

        // Verify the text 'Electronics'
        WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(text(),'Electronics')]"));
        Assert.assertEquals("Electronics" , pageTitle.getText());
    }
    @Test
    public void userShouldNavigateToApparelAndShoesPageSuccessfully() {
        // Click on the 'APPAREL & SHOES' Tab
        WebElement apparelTab = driver.findElement(By.linkText("Apparel & Shoes"));
        apparelTab.click();

        // Verify the text 'Apparel & Shoes'
        WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(text(),'Apparel & Shoes')]"));
        Assert.assertEquals("Apparel & Shoes", pageTitle.getText());
    }
    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        // Click on the 'DIGITAL DOWNLOADS' Tab
        WebElement digitalDownloadsTab = driver.findElement(By.linkText("Digital downloads"));
        digitalDownloadsTab.click();

        // Verify the text 'Digital downloads'
        WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(text(),'Digital downloads')]"));
        Assert.assertEquals("Digital downloads", pageTitle.getText());
    }
    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        // Click on the 'BOOKS' Tab
        WebElement booksTab = driver.findElement(By.linkText("Books"));
        booksTab.click();

        // Verify the text 'Books'
        WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(text(),'Books')]"));
        Assert.assertEquals("Books", pageTitle.getText());
    }
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        // Click on the 'JEWELRY' Tab
        WebElement jewelryTab = driver.findElement(By.linkText("Jewelry"));
        jewelryTab.click();

        // Verify the text 'Jewelry'
        WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(text(),'Jewelry')]"));
       Assert.assertEquals("Jewelry", pageTitle.getText());
    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        // Click on the 'GIFT CARDS' Tab
        WebElement giftCardsTab = driver.findElement(By.linkText("Gift Cards"));
        giftCardsTab.click();

        // Verify the text 'Gift Cards'
        WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(text(),'Gift Cards')]"));
        String expectedErrorMessage = "Gift Cards";
        Assert.assertEquals("Gift Cards", expectedErrorMessage,pageTitle);
    }

    @After
    public void tearDown() {
         closeBrowser();
    }
}
