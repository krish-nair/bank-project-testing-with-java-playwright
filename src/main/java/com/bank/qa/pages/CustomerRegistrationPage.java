package com.bank.qa.pages;

import com.microsoft.playwright.Page;

public class CustomerRegistrationPage {
    Page page;
    private final String registrationSuccessMsg = "//p[text()='Customer Registered Successfully!!!']";
    private final String customerId = "((//table[@id='customer']/tbody/tr)[4]/td)[2]";

    public CustomerRegistrationPage(Page page) {
        this.page = page;
    }

    public String getCustomerId(){
        return page.innerText(customerId);
    }
    public String getRegistrationSuccessMsg(){
        return page.innerText(registrationSuccessMsg);
    }
    public String pageTitle(){
        page.waitForTimeout(5000);
        return page.title();
    }
}
