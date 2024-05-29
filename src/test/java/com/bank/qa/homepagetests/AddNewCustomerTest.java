package com.bank.qa.homepagetests;

import com.bank.qa.base.BaseTest;
import com.bank.qa.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewCustomerTest extends BaseTest {

    @Test(priority = 1)
    public void shouldFillAndSubmitNewCustomerForm(){
        bankManagerHomePage = loginPage.loginWithTheCredentials(prop.getProperty("username"), prop.getProperty("password"));
        addNewCustomerPage = bankManagerHomePage.clickNewCustomerLink();
        customerRegistrationPage = addNewCustomerPage.submitForm();
        String actualPageTitle = customerRegistrationPage.pageTitle();
        String actualSuccessMsg = customerRegistrationPage.getRegistrationSuccessMsg();
        Assert.assertEquals(actualPageTitle, AppConstants.REGISTRATION_PAGE_TITLE);
        Assert.assertEquals(actualSuccessMsg, AppConstants.REGISTRATION_SUCCESS_MSG);
        String customerId = customerRegistrationPage.getCustomerId();
        writeExcelData.writeExcelData("Sheet1", 2, 1, customerId);
        System.out.println(customerId);
    }
}
