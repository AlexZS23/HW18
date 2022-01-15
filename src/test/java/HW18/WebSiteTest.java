package HW18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebSiteTest {

    WebDriver webDriver;
    BaseTest baseTest = new BaseTest();
    String email = baseTest.generateEmail();


    @BeforeClass
    public void WebDriverLaunch() {
        webDriver = BaseTest.webDriverInit();
    }

    //generate random email, and check register form is displayed
    @Test
    public void FirstTest() {
//        System.out.println(email);
        webDriver.get("http://automationpractice.com/");
        By signIn = By.xpath("//a[@class='login']");
        webDriver.findElement(signIn).click();
        webDriver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(email);
        webDriver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(webDriver.getCurrentUrl().contains("account-creation"), "Current URL doesn't contain 'account-creation'");
    }

    //verify that error 'email already exist' is displayed
    @Test
    public void SecondTest() {

        webDriver.get("http://automationpractice.com/");
        By signIn = By.xpath("//a[@class='login']");
        webDriver.findElement(signIn).click();
        webDriver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("example@gmail.com");
        webDriver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(webDriver.findElement(By.xpath("//div[@id='create_account_error']")).getText().contains("An account using this email address has already been registered."));
    }

    @AfterClass
    public void closeWebSite() {
        webDriver.quit();
    }

}
