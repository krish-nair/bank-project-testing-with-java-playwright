package com.bank.qa.pages;

import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    Page page;

//    private String username = "//input[@name='uid']";
    private final Locator username;
    private String password = "//input[@name='password']";
    private String loginBtn = "//input[@name='btnLogin']";

    public LoginPage(Page page) {
        this.page = page;
        this.username = page.locator("//input[@name='uid']");
    }

    public String getPageTitle(){
        return page.title();
    }

    /*public void enterUsername(String uname){
        username.fill(uname);
//        page.fill(username, uname);
    }
    public void enterPassword(String psd){
        page.fill(password, psd);
    }*/

    public BankManagerHomePage loginWithTheCredentials(String uname, String psd){
        username.fill(uname);
        page.fill(password, psd);
        page.click(loginBtn);
        page.waitForTimeout(3_000);
        return new BankManagerHomePage(page);
    }

    public void acceptDialogueMessage(){
        page.onDialog(Dialog::accept);
        page.waitForTimeout(3_000);
    }

}
