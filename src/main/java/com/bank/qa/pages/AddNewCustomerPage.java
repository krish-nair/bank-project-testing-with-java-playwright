package com.bank.qa.pages;

import com.microsoft.playwright.Page;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class AddNewCustomerPage {
    Page page;
    private String addNewCustomerFormTitle = "text=Add New Customer";

    private final String custName = "//input[@name='name']";
    private final String gender = "//input[@value='f']";
    private final String date = "//input[@id='dob']";
    private final String emailField = "input[name='emailid']";
    private final String passwordField = "input[name='password']";
    private final String addressField = "//textarea";
    private final String cityField = "//input[@name='city']";
    private final String stateField = "//input[@name='state']";
    private final String pinNoField = "//input[@name='pinno']";
    private final String mobileField = "//input[@name='telephoneno']";
    private final String submitBtn = "//input[@name='sub']";

    public AddNewCustomerPage(Page page) {
        this.page = page;
    }

    public String getPageTitle(){
        return page.title();
    }
    public CustomerRegistrationPage submitForm(){
        addCustomerNameAndGender();
        addCustomerDob();
        enterAddressCityStatePinAndMobileNo(randomTextGenerator(), randomNameGenerator(),randomTextGenerator(),randomNumber(111111,999999), randomNumber(22222222, 99999999));
        addEmail();
        addPassword();
        page.click(submitBtn);
        return new CustomerRegistrationPage(page);
    }
    public void addEmail(){
        page.fill(emailField, randomTextGenerator()+ "@mail.com");
    }
    public void addPassword(){
        page.fill(passwordField, "123456");
    }

    public void enterAddressCityStatePinAndMobileNo(String addr, String city, String state, String pinNum, String mobileNo){
        page.fill(addressField, addr);
        page.fill(cityField, city);
        page.fill(stateField, state);
        page.fill(pinNoField, pinNum);
        page.fill(mobileField, mobileNo);
    }
    public void addCustomerDob(){
        page.click(date);
        page.keyboard().press("ArrowLeft");
        page.keyboard().press("ArrowLeft");
        page.keyboard().type(getDay());
        page.keyboard().type(getMonth());
        page.keyboard().type(getYear());
        page.keyboard().press("Tab");
    }
    public void addCustomerNameAndGender(){
        page.click(custName);
        page.press(custName, "Control+a+Backspace");
        page.fill(custName, randomNameGenerator());
        page.click(gender);
    }
    public String getAddNewCustomerFormTitle(){
        return page.innerText(addNewCustomerFormTitle);
    }
    public String getDob() {
        Long yearToMinus = Long.valueOf(randomNumber(18, 50));
        LocalDate date1 = LocalDate.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd");
        LocalDate date = date1.minusYears(yearToMinus);
        String dob = date.format(df);
        return dob;
    }
    private String getDay() {
        LocalDate date1 = LocalDate.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd");
        String day = date1.format(df);
        return day;
    }
    private String getMonth() {
        LocalDate date1 = LocalDate.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM");
        String month = date1.format(df);
        return month;
    }
    private String getYear() {
        LocalDate date1 = LocalDate.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy");
        long randomYear = Long.parseLong(randomNumber(18, 50));
        LocalDate date = date1.minusYears(randomYear);
        String year = date.format(df);
        return year;
    }

    private String randomNumber(int min, int max) {

        int num = (int) (Math.random() * (max - min) + min);

        return String.valueOf(num);
    }

    private String randomNameGenerator(){
        String[] firstName = {"John","Mike", "Mohan", "Richard", "Karyn", "Kevin"};
        String[] lastName = {"Fortune", "Wilson", "Murray", "Randell", "Sharma", "Sim"};
        Random random = new Random();
        String fullName = firstName[random.nextInt(firstName.length)]
                + " " + lastName[random.nextInt(lastName.length)];
        return fullName;
    }

    private String randomTextGenerator(){
        String text = "";
        String letters = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        int length = 5;
        for (int i = 0; i < length; i++){
            int index = random.nextInt(letters.length());
            char randomChar = letters.charAt(index);
            text = String.valueOf(stringBuilder.append(randomChar));
        }
        return text;

    }

}
