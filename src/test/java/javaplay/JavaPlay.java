package javaplay;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import javax.swing.text.DateFormatter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class JavaPlay {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.put("userId", "9874");
        properties.put("username", "Tester");
        FileOutputStream fos = new FileOutputStream("src/main/resources/configWrite.properties", false);
        properties.store(fos, "User details are stored");
        System.out.println("file is created");



        /*ArrayList<String> names = new ArrayList<>();

        names.add("John");
        names.add(0, "Mohan");
        names.add("Krish");
        names.forEach((p)-> System.out.println(p));


        System.out.println(names);
        System.out.println(names.size());
        System.out.println(names.contains("krish"));*/
//        ArrayList<Integer> nums = new ArrayList<>();
//        nums.add(5);
//        nums.add(15);
//        nums.add(25);
//        nums.add(35);
//        nums.add(45);
//        nums.add(55);
//
//        System.out.println(nums);
//        nums.forEach((n)-> System.out.println(n*2));
//
//        for (int i = 0; i < nums.size(); i++){
//            System.out.println("numbers "+ nums.get(i));
//        }
//        System.out.println();
//        System.out.println();
//
//        for (Integer num: nums){
//            System.out.println("Num: "+ num);
//        }
    }
    @Test
    public void randomName(){
        String[] firstName = {"John","Mike", "Mohan", "Richard", "Karyn", "Kevin"};
        String[] lastName = {"Fortune", "Wilson", "Murray", "Randell", "Sharma", "Sim"};
        Random random = new Random();
//        ArrayList<String> firstName = new ArrayList<>();
//        ArrayList<String> lastName = new ArrayList<>();
//        Random random = new Random();
//        firstName.add("John");
//        firstName.add("Mike");
//        firstName.add("Mohan");
//        firstName.add("Richard");
//        firstName.add("Karyn");
//        firstName.add("Kevin");
//        lastName.add("Fortune");
//        lastName.add("Wilson");
//        lastName.add("Murray");
//        lastName.add("Randell");
//        lastName.add("Sharma");
//        lastName.add("Sim");
//        System.out.println(firstName.get(random.nextInt(firstName.size())) + " "
//        + lastName.get(random.nextInt(lastName.size())));

        System.out.println(firstName[random.nextInt(firstName.length)] + " " + lastName[random.nextInt(lastName.length)]);
    }

    @Test
    public static void getCustomerId() throws IOException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate("https://demo.guru99.com/v4/manager/CustomerRegMsg.php?cid=26035");

        page.waitForTimeout(5000);
        String cid = "((//table[@id='customer']/tbody/tr)[4]/td)[2]";
        page.innerText(cid);
        System.out.println(page.innerText(cid));

        Properties properties = new Properties();
        properties.put("userId", page.innerText(cid));
        //properties.put("username", "Tester");
        FileOutputStream fos = new FileOutputStream("src/main/resources/configWrite.properties", false);
        properties.store(fos, "User details are stored");
        System.out.println("file is created");
    }

    public static void writeCidToConfig() throws IOException {
        Properties properties = new Properties();
        properties.put("userId", "");
        properties.put("username", "Tester");
        FileOutputStream fos = new FileOutputStream("src/main/resources/configWrite.properties", false);
        properties.store(fos, "User details are stored");
        System.out.println("file is created");
    }
}
