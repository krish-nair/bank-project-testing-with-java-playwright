package com.bank.qa.base;

import com.bank.qa.pages.AddNewCustomerPage;
import com.bank.qa.pages.BankManagerHomePage;
import com.bank.qa.pages.CustomerRegistrationPage;
import com.bank.qa.pages.LoginPage;
import com.bank.qa.playwrightfactory.PlaywrightFactory;
import com.bank.qa.utils.ReadExcelData;
import com.bank.qa.utils.WriteExcelData;
import com.bank.qa.utils.XLUtils;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    PlaywrightFactory pf;
    Page page;
    protected Properties prop;
    protected LoginPage loginPage;
    protected BankManagerHomePage bankManagerHomePage;
    protected AddNewCustomerPage addNewCustomerPage;
    protected CustomerRegistrationPage customerRegistrationPage;
    protected ReadExcelData readExcelData;
    protected WriteExcelData writeExcelData;
    protected XLUtils xlUtils;
    @BeforeTest
    public void setup(){
        pf = new PlaywrightFactory();
        prop = pf.initProperties();
        page = pf.launchBrowser(prop);
        loginPage = new LoginPage(page);
        bankManagerHomePage = new BankManagerHomePage(page);
        addNewCustomerPage = new AddNewCustomerPage(page);
        customerRegistrationPage = new CustomerRegistrationPage(page);
        readExcelData = new ReadExcelData();
        writeExcelData = new WriteExcelData();
        xlUtils = new XLUtils();
    }

    @AfterTest
    public void tearDown(){
//        page.context().browser().close();
//        page.pause();
    }
}
