package ru.geekbrains.level3.lession3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrmTests {

    private static final String CRM_URL = "https://crm.geekbrains.space";
    private static final String LOGIN = "Applanatest1";
    private static final String PASS = "Student2020!";

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(CRM_URL);
        login();

        driver.findElements(By.xpath("//span[text()='Расходы']")).get(0).click();
        driver.findElement(By.xpath("//span[text()='Заявки на расходы']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Создать заявку на расход']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//textarea[contains(@id, 'crm_expense_request_description')]")).sendKeys("TestText");






        Thread.sleep(5000);
        driver.quit();

    }

    public static void login(){
        driver.findElement(By.id("prependedInput")).sendKeys(LOGIN);
        driver.findElement(By.id("prependedInput2")).sendKeys(PASS);
        driver.findElement(By.id("_submit")).click();
    }
}
