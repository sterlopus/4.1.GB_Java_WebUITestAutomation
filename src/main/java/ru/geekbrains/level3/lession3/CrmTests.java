package ru.geekbrains.level3.lession3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrmTests {

    private static final String CRM_URL = "https://crm.geekbrains.space";
    private static final String LOGIN = "Applanatest1";
    private static final String PASS = "Student2020!";

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(CRM_URL);
        login();




//        Thread.sleep(5000);



        driver.quit();

    }

    public static void login(){
        driver.findElement(By.id("prependedInput")).sendKeys(LOGIN);
        driver.findElement(By.id("prependedInput2")).sendKeys(PASS);
        driver.findElement(By.id("_submit")).click();
    }
}
