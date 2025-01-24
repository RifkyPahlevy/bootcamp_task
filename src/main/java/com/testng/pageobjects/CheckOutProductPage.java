package com.testng.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutProductPage {

    WebDriver driver ;
    
    public CheckOutProductPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "a[class='shopping_cart_link']")
    WebElement iconShopElm;


    @FindBy (css = "button[id='checkout']")
    WebElement btnCheckoutElm;

    @FindBy (css = "input[id='postal-code']")
    WebElement postalCodeElm;

    @FindBy (css = "input[id='last-name']")
    WebElement lastNameElm;

    @FindBy (css = "input[id='first-name']")
    WebElement firstNameElm;

    
    @FindBy (css = "input[id='continue']")
    WebElement btnContinueElm;

    @FindBy (css = "button[id='finish']")
    WebElement btnFinishElm;

    @FindBy (css = "h2[class='complete-header']")
    public WebElement txtValidateOrder;
    

    public void checkOutProduct() throws InterruptedException {
        iconShopElm.click();
        
        Thread.sleep(200);

        btnCheckoutElm.click();
    }

    public void submitForm (String firstName,String lastName,String postCode){
        firstNameElm.sendKeys(firstName);
        lastNameElm.sendKeys(lastName);
        postalCodeElm.sendKeys(postCode);

        btnContinueElm.click();

    }

    public void clickFinish (){
        btnFinishElm.click();
    }
}
