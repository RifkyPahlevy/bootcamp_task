package com.testng.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);//wajib dipakai ketika menggunakan pom
    }



    @FindBy(css = "input[id='user-name']")
    WebElement userElement;
    
    @FindBy(css = "input[id='password']")
    WebElement passworElement;

    @FindBy(css = "input[id='login-button'")
    WebElement buttonLoginElement;

    @FindBy(css = "button[type='button']")
    public  WebElement buttonValidateElm;


    public void loginApplication (String userEmail, String passwordUser){

        userElement.sendKeys(userEmail);
        passworElement.sendKeys(passwordUser);
        buttonLoginElement.click();

        


    }


}
