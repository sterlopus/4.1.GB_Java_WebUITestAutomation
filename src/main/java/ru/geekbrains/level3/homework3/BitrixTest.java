package ru.geekbrains.level3.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BitrixTest {
    private static final String CRM_URL = "https://b24-in8ijg.bitrix24.ru";
    private static final String LOGIN = "gleb.smirnov@me.com";
    private static final String PASS = "Bitrix24-gbuser";

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.get(CRM_URL);
        driver.manage().window().maximize();

        login();

        //locate the menu to hover to get plus symbol to click
        WebElement menu = driver.findElement(By.linkText("Сделки"));
        Actions builder = new Actions(driver);
        builder.moveToElement(menu).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/crm/deal/details/0/']")));
        driver.findElement(By.xpath("//a[@href='/crm/deal/details/0/']")).click();

        // move scope to iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='side-panel-iframe']")));

        // filling the forms
        driver.findElement(By.xpath("//input[@name='TITLE']")).sendKeys("Deal #1");
        driver.findElement(By.xpath("//input[contains(@class,'ui-ctl-inline')]")).clear();
        driver.findElement(By.xpath("//input[contains(@class,'ui-ctl-inline')]")).sendKeys("75000");
        driver.findElement(By.xpath("//input[contains(@placeholder, 'Имя контакта, телефон или e-mail')]"))
                .sendKeys("Дмитрий Степанов");
        driver.findElement(By.xpath("//input[contains(@placeholder, 'Название компании, телефон или e-mail')]"))
                .sendKeys("Астер");

        // save form
        driver.findElement(By.xpath("//button[text()='Сохранить']")).click();

        // close DEAL form
//        driver.findElement(By.xpath("//div[contains(@class, 'side-panel-label-icon-close')]")).click();
//        driver.findElement(By.xpath("//div[@title='Закрыть']")).click();
        driver.findElement(By.xpath("//span[text()='Сделка']")).click();
        //todo  может не сумел в родительский фрейм вернуться??




        Thread.sleep(5000);
//        driver.quit();

    }

    public static void login() {
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(LOGIN);
        driver.findElement(By.xpath("//button[text()='Далее']")).click();
        driver.findElement(By.xpath("//button[text()='Далее']")).click();   // прокликивается только на 4-й раз,
        driver.findElement(By.xpath("//button[text()='Далее']")).click();   // несмотря на задержку/неявное ожидание
        driver.findElement(By.xpath("//button[text()='Далее']")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(PASS);
        driver.findElement(By.xpath("//button[text()='Далее']")).click();
    } //todo please look inside - 4 clicks on one button

}
