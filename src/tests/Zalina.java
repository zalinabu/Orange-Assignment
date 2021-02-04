import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Zalina {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/davidtsutskiridze/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/client/#/dashboard");

        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.id("menu_admin_viewAdminModule")).click();

        driver.findElement(By.xpath("//span[text()='Announcements']")).click();
        //clicking News
        driver.findElement(By.xpath("//span[text()='News']")).click();



        //driver.findElement(By.xpath(" //a[@id='menu_news_viewNewsArticles']")).click();


    }



}

