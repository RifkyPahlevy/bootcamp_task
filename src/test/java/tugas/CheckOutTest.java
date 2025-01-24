package tugas;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testng.pageobjects.CheckOutProductPage;
import com.testng.pageobjects.LoginPage;
import com.testng.pageobjects.ProductsPage;

public class CheckOutTest {
    
    WebDriver driver = null;
    @BeforeTest
    public void setup (){
       driver = new ChromeDriver();
    }

    @Test(dataProvider = "getData")
    public void checkoutProduct(HashMap<String,String> inputMap) throws InterruptedException {
       

        String successOrder = inputMap.get("validate");

        driver.get(inputMap.get("url"));
        
        Thread.sleep(100);

        driver.manage().window().maximize();
        
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginApplication(inputMap.get("email"), inputMap.get("password"));

        String validateLogin = loginPage.buttonValidateElm.getText();

        Assert.assertTrue(validateLogin.equals("Open Menu"));

        ProductsPage product = new ProductsPage(driver);

        product.addProduct(inputMap.get("product"));

        Thread.sleep(100);

        CheckOutProductPage cart = new CheckOutProductPage(driver);
        cart.checkOutProduct();


        Thread.sleep(100);

        cart.submitForm(inputMap.get("first_name"), inputMap.get("last_name"), inputMap.get("post_code"));

        Thread.sleep(100);

        cart.clickFinish();

        Thread.sleep(100);

        Assert.assertTrue(successOrder.equals(cart.txtValidateOrder.getText()));

        driver.quit();

    }

    @DataProvider 
    public Object [][] getData (){
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("url", "https://www.saucedemo.com/");
        map.put("validate", "Thank you for your order!");
        map.put("email", "standard_user");
        map.put("password", "secret_sauce");
        map.put("product", "Sauce Labs Backpack");
        map.put("first_name", "kiki");
        map.put("last_name", "levy");
        map.put("post_code", "2121");

        return new Object[][] {{map}};

    }
}
