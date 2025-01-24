package tugas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginSample {

    static WebDriver driver = new ChromeDriver();

    @Test
    public void loginPage () throws InterruptedException{
        driver.get("https://www.saucedemo.com/");
        
        Thread.sleep(100);

        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("input[id=\"user-name\"]")).sendKeys("standard_user");

        driver.findElement(By.cssSelector("input[id=\"password\"]")).sendKeys("secret_sauce");

        driver.findElement(By.cssSelector("input[id=\"login-button\"]")).click();

        Thread.sleep(200);

        driver.findElement(By.cssSelector("div[class=\"bm-burger-button\"]")).click();

        driver.findElement(By.cssSelector("div[class=\"bm-burger-button\"]")).getText();

        String buttonValidate = driver.findElement(By.cssSelector("div[class=\"bm-burger-button\"]")).getText();

        Assert.assertEquals(buttonValidate, "Open Menu");

        driver.quit();
        
    }
}
