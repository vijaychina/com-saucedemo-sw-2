package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter "tomsmith" username
        driver.findElement(By.name("username")).sendKeys("tomsmith");

        //Enter "SuperSecretPassword" password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //Click on "Login" button
        driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();

        //Verify the next "Secure Area"
        String expectedMessage = "Secure Area";
        WebElement actualTextElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h2"));
        String actualMessage = actualTextElement.getText();
        boolean trueMessage = actualMessage.contains(expectedMessage);
        Assert.assertTrue(trueMessage);
    }
    /*2. verifyTheUsernameErrorMessage
    * Enter “tomsmith1” username
    * Enter “SuperSecretPassword!” password
    * Click on ‘LOGIN’ button
    * Verify the error message “Your username
    is invalid!”
    */
    @Test
    public void verifyTheUsernameErrorMessage() {
        //Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");

        //Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        //Verify the error message “Your username is invalid!”
        String expectedMessage = "Your username is invalid!";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actualTextElement.getText();
        boolean trueMessage = actualMessage.contains(expectedMessage);
        Assert.assertTrue(trueMessage);
    }

    /*3. verifyThePasswordErrorMessage
     * Enter “tomsmith” username
     * Enter “SuperSecretPassword” password
     * Click on ‘LOGIN’ button
     * Verify the error message “Your password is invalid!”
     */
    @Test
    public void verifyThePasswordErrorMessage() {
        //Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        //Enter “SuperSecretPassword” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        //Verify the error message “Your password is invalid!”
        String expectedMessage = "Your password is invalid!";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[contains(text(),'Your password is invalid!')]"));
        String actualMessage = actualTextElement.getText();
        boolean trueMessage = actualMessage.contains(expectedMessage);
        Assert.assertTrue(trueMessage);

    }

    @After
    public void tearDown() {
        //closeBrowser

    }

}
