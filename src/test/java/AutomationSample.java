import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AutomationSample {

    public static void main(String[] args) throws InterruptedException  {

        
        String menu = "Documentation";

        WebElement chooseMenu = null;

        WebDriver driver = new ChromeDriver();

        driver.get("https://selenium.dev");

        driver.manage().window().maximize();

        Thread.sleep(300);

        List <WebElement> listMenu = driver.findElements(By.cssSelector("li[class=\"nav-item mr-4 mb-2 mb-lg-0\"]"));

        

        for (WebElement webElement : listMenu) {
            String menuName = webElement.findElement(By.cssSelector("a[href]")).getText();
            if (menu.equals(menuName)) {
                chooseMenu = webElement;
                break;
            }
            
            //System.out.println(webElement.findElement(By.cssSelector("a[href]")).getText());
        }

        //driver.findElement(By.xpath("//li[@class=\"nav-item mr-4 mb-2 mb-lg-0\"]/a[@href=\"/downloads\"]")).click();
        chooseMenu.findElement(By.cssSelector("span")).click();

        Thread.sleep(200);
        
        driver.quit();
    }
}
