package com.BrireERP.tests;

import com.BrireERP.pages.CRMPage;
import com.BrireERP.pages.LoginPage;
import com.BrireERP.utilities.ConfigurationReader;
import com.BrireERP.utilities.TestBase;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test(priority = 1)
    public void preConditionTest() {
        extentLogger = report.createTest("Precondition");
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.getProperty("salesmanagerusername"), ConfigurationReader.getProperty("salesmanagerpassword"));
        loginPage.goToModule("CRM");

        CRMPage crmPage = new CRMPage();

        crmPage.clickCreateBtn();
        crmPage.enterOpportunityTitle("Book Sale11");
        crmPage.enterExpectedRevenue("500.00");
        crmPage.createOpportunityButton();

        crmPage.clickCreateBtn();
        crmPage.enterOpportunityTitle("Book Sale12");
        crmPage.enterExpectedRevenue("300.00");
        crmPage.createOpportunityButton();

        crmPage.clickCreateBtn();
        crmPage.enterOpportunityTitle("Book Sale13");
        crmPage.enterExpectedRevenue("400.00");
        crmPage.createOpportunityButton();

        crmPage.pivotViewBtn();
        crmPage.expandTotalAndSelect("Opportunity");

        String pivotExpectedRevenue = crmPage.getExpectedRevenuePivot("Book Sale12");
        crmPage.listViewBtn();
        String listExpectedRevenue = crmPage.getExpectedRevenueList("Book Sale12");

        Assert.assertEquals(pivotExpectedRevenue, listExpectedRevenue);
    }

    @Test(priority = 2, dependsOnMethods = "preConditionTest")
    public void deleteAllOpportunities() {
        extentLogger = report.createTest("Precondition");
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.getProperty("salesmanagerusername"), ConfigurationReader.getProperty("salesmanagerpassword"));
        loginPage.goToModule("CRM");

        CRMPage crmPage = new CRMPage();
        crmPage.listViewBtn();
        crmPage.deleteAllOpportunities();


    }


}
