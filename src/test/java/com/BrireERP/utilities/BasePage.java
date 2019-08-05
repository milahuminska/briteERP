package com.BrireERP.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    public void goToModule(String moduleName){
        Driver.getDriver().findElement(By.xpath("//span[@class='oe_menu_text' and contains(text(),'"+moduleName+"')]")).click();
    }

}
