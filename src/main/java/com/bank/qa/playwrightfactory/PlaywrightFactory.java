package com.bank.qa.playwrightfactory;

import com.microsoft.playwright.*;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class PlaywrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;
    String bankHomePage = "https://demo.guru99.com/v4/";
    private static ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> browserContextThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<Page> pageContextThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();

    public static Playwright getPlaywright(){
        return playwrightThreadLocal.get();
    }
    public static Browser getBrowser(){
        return browserThreadLocal.get();
    }
    public static BrowserContext getBrowserContext(){
        return browserContextThreadLocal.get();
    }
    public static Page getPage(){
        return pageContextThreadLocal.get();
    }

    public Page launchBrowser(Properties prop){
        String browserName = prop.getProperty("browser").trim();
        System.out.println("Browser name is "+ browserName);
        //playwright = Playwright.create(); //without thread local feature.
        playwrightThreadLocal.set(Playwright.create());

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        double width = (int)dimension.getWidth();
        double height = (int)dimension.getHeight();

        switch (browserName.toLowerCase()){
            case "chromium":
                //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); //without thread local feature.
                browserThreadLocal.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
            break;
            case "firefox":
                //browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                browserThreadLocal.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "safari":
                //browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                browserThreadLocal.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "chrome":
                //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
                browserThreadLocal.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")));
                break;
            default:
                System.out.println("Please check the browser name is correct");
        }

//        browserContext = browser.newContext(new Browser.NewContextOptions()
//                .setViewportSize((int) width, (int) height));
        //        browserContext = browser.newContext(); //without viewport size defined.
        browserContextThreadLocal.set(getBrowser().newContext());

        //browserContextThreadLocal.set(getBrowser().newContext(new Browser.NewContextOptions()
                //.setViewportSize((int) width, (int) height)));
        //page = browserContext.newPage();
        pageContextThreadLocal.set(getBrowserContext().newPage());
        getPage().navigate(bankHomePage);

        return getPage();
    }

    public Properties initProperties(){
        FileInputStream fis;
        try {
            fis = new FileInputStream("src/main/resources/config/config.properties");
            prop = new Properties();
            prop.load(fis);
        }
          catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
          catch (IOException e) {
              throw new RuntimeException(e);
          }

        return prop;
    }
}
