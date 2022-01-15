package HW18;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static WebDriver webDriverInit(){

        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        return chromeDriver;
    }

    public String generateEmail() {

        String symbols = "abcdefghijklmnopqrstuvwxyz0123456789";
        char[] tempValues = symbols.toCharArray();
        int temp;

        char[] valuesFinal = new char[7]; //задаем длину первой части email

        for (int i = 0; i < valuesFinal.length; i++) {
            temp = (int) (Math.random() * (tempValues.length));
            valuesFinal[i] = tempValues[temp];
        }

        return String.valueOf(valuesFinal) + "@gmail.com";
    }
}
