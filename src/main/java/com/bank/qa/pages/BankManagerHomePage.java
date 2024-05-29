package com.bank.qa.pages;

import com.microsoft.playwright.Page;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class BankManagerHomePage {
    Page page;

    private String pageHeading3 = "marquee.heading3";
    private String newCustomerLink = "text=New Customer";



    public BankManagerHomePage(Page page) {
        this.page = page;
    }


    public String getBankManagerHomePageTitle(){
        return page.title();
    }

    public String getPageHeading3(){
       return page.innerText(pageHeading3);
    }

    public AddNewCustomerPage clickNewCustomerLink(){
        page.click(newCustomerLink);
        page.reload();
        page.waitForTimeout(3_000);
        page.click(newCustomerLink);
        return new AddNewCustomerPage(page);
    }
}
