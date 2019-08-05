package com.BrireERP.pages;

import com.BrireERP.utilities.BasePage;
import com.BrireERP.utilities.BrowserUtils;
import com.BrireERP.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMPage extends BasePage {


    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o-kanban-button-new' and contains(text(),'Create')]")
    public WebElement createBtn;

    @FindBy (xpath = "//*[contains(text(),'Opportunity Title')]/../following-sibling::td//input")
    public WebElement opportunityTitle;

    @FindBy(xpath = "//*[contains(text(),'Customer')]/../following-sibling::td//input")
    public WebElement customer;

    @FindBy(xpath = "//*[contains(text(),'Expected Revenue')]/../following-sibling::td//input")
    public  WebElement expectedRevenue;

    @FindBy (xpath = "//*[contains(text(),'Priority')]/../following-sibling::td//a[@title='Very High']")
    public WebElement treeStars;

    @FindBy (xpath = "//span[text()='Create']")
    public WebElement createOpportunityBtn;

    @FindBy (css = "button[data-view-type='pivot']")
    public WebElement pivotView;

    @FindBy(css ="td[class='o_pivot_header_cell_closed']")
    public WebElement totalPlus;

    @FindBy (css = "button[data-view-type='list']")
    public WebElement listView;

    @FindBy(css = "th input")
    public WebElement selectAllOpportunities;

    @FindBy(xpath = "//button[contains(text(),'Action')]")
    public WebElement actions;

    @FindBy(xpath = "//a[contains(text(),'Delete')]")
    public WebElement deleteOption;

    @FindBy(xpath = "//*[contains(text(),'Ok')]")
    public WebElement okBtn;




    public void clickCreateBtn() {
        BrowserUtils.waitForVisibility(createBtn, 10);
        BrowserUtils.clickWithTimeOut(createBtn, 5);
    }

    public void enterOpportunityTitle(String titleText){
        opportunityTitle.sendKeys(titleText);
    }

//    public void enterCustomer(String customerText){
//        customer.sendKeys(customerText);
//    }

    public void enterExpectedRevenue(String expectedRevenueText){
        expectedRevenue.clear();
       expectedRevenue.sendKeys(expectedRevenueText);
    }

//    public void enterPriority(){
//        treeStars.click();
//    }

    public void createOpportunityButton(){
        createOpportunityBtn.click();
    }

    public void pivotViewBtn(){
        BrowserUtils.waitForStaleElement(pivotView);
        BrowserUtils.waitForClickablility(pivotView, 5);
        BrowserUtils.clickWithTimeOut(pivotView, 5);
    }

    public void listViewBtn(){
        BrowserUtils.waitForStaleElement(listView);
        BrowserUtils.waitForClickablility(listView, 5);
        BrowserUtils.clickWithTimeOut(listView, 5);
    }


    public void expandTotalAndSelect(String text){
        totalPlus.click();
        Driver.getDriver().findElement(By.xpath("//ul[@class='dropdown-menu o_pivot_field_menu']//a[text()='"+text+"']")).click();
    }

    public String getExpectedRevenuePivot(String opportunityTitle){
        String locator = "//td[@class='o_pivot_header_cell_closed' and contains(text(),'"+opportunityTitle+"')]/following-sibling::td[1]";
        return Driver.getDriver().findElement(By.xpath(locator)).getText();
    }

    public String getExpectedRevenueList(String opportunityTitle){
        String locator = "//td[@class='o_data_cell o_required_modifier' and contains(text(),'"+opportunityTitle+"')]/following-sibling::td[6]";
        return Driver.getDriver().findElement(By.xpath(locator)).getText();
    }

    public void deleteAllOpportunities() {
        selectAllOpportunities.click();
        actions.click();
        deleteOption.click();
        okBtn.click();
    }
}
