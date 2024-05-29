package com.bank.qa.homepagetests;

import com.bank.qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankManagerHomePageTest extends BaseTest {
    @Test
    public void shouldNavigateToAddNewCustomerForm(){
        bankManagerHomePage = loginPage.loginWithTheCredentials(prop.getProperty("username"), prop.getProperty("password"));
        addNewCustomerPage = bankManagerHomePage.clickNewCustomerLink();
        String actualPageTitle = addNewCustomerPage.getPageTitle();
        String actualFormTitle = addNewCustomerPage.getAddNewCustomerFormTitle();
        Assert.assertEquals(actualPageTitle, "Guru99 Bank New Customer Entry Page");
        Assert.assertEquals(actualFormTitle, "Add New Customer");

    }

}
