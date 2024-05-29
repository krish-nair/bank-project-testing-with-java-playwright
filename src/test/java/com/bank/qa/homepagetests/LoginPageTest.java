package com.bank.qa.homepagetests;

import com.bank.qa.base.BaseTest;
import com.bank.qa.constants.AppConstants;
import com.bank.qa.utils.XLUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends BaseTest {
    @Test
    public void shouldGetHomePageTitle(){
        String pageTitle = loginPage.getPageTitle();
        Assert.assertEquals(pageTitle, AppConstants.HOMEPAGE_TITLE);
    }

    @Test(priority = 1)
    public void shouldNotLoginWithInvalidCredentials(){
        loginPage.loginWithTheCredentials(prop.getProperty("username"), prop.getProperty("invalidPassword"));
        loginPage.acceptDialogueMessage();
        Assert.assertEquals(loginPage.getPageTitle(), AppConstants.HOMEPAGE_TITLE);
    }
    @Test(priority = 2)
    public void shouldLoginWithValidCredentials(){
        loginPage.loginWithTheCredentials(prop.getProperty("username"), prop.getProperty("password"));
       Assert.assertEquals(bankManagerHomePage.getBankManagerHomePageTitle(), AppConstants.BANK_MANAGER_HOMEPAGE_TITLE);
       Assert.assertEquals(bankManagerHomePage.getPageHeading3(), "Welcome To Manager's Page of Guru99 Bank");
    }

    /*@DataProvider(name = "testData")
    public String[][] getData(){
        try {
            int rowCount = XLUtils.getRowCount(prop.getProperty("xlsFilePath"),"Sheet1");
            int colCount = XLUtils.getCellCount(prop.getProperty("xlsFilePath"), "Sheet1", 1);
            String data[][] = new String[rowCount][colCount];
            for (int i=1; i <= rowCount; i++){
                for (int j=0; j < colCount; j++){
                    data[i-1][j] = XLUtils.getCellData(prop.getProperty("xlsFilePath"),"Sheet1", i, j);
                }
            }

            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
}
