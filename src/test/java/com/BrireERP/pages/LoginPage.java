package com.BrireERP.pages;

import com.BrireERP.utilities.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    @FindBy(id = "login")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath  = "//button[@type='submit']")
    public WebElement loginBtn;

    public void login(String emailText,String passwordText){
        email.sendKeys(emailText);
        password.sendKeys(passwordText);
        loginBtn.click();

    }



}
