package com.testng.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    WebDriver driver;
    String product ;

    WebElement chooseProduct = null;
    
    
    public ProductsPage (WebDriver driver){
        this.driver = driver;
        
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(css = "button[id='add-to-cart-sauce-labs-backpack']")
    WebElement productElm;

    @FindBy(css = "button[name='add-to-cart']")
    WebElement btnAddToCartElm;

    @FindBy(css = ".inventory_item_name")
     List<WebElement> listProductsElm;


     public void addProduct (String product) throws InterruptedException{
        System.out.println("tessssss");
        for (WebElement webElement : listProductsElm) {
            System.out.println("Ini List : "+webElement.getText());
           String productName = webElement.getText();
           if (product.contains(productName)) {
                chooseProduct = webElement;
                break;            
           }
        }
        
        chooseProduct.click();

        Thread.sleep(200);

        btnAddToCartElm.click();

        //System.out.println( chooseProduct.findElement(By.cssSelector("button[class='btn btn_primary btn_small btn_inventory ']")).getText());
       

        //chooseProduct.findElement(By.cssSelector("button[class='btn btn_primary btn_small btn_inventory ']")).click();
        
       




     }
}
