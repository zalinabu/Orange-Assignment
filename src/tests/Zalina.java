import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zalina {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/oleksiinikitenko/Desktop/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/client/#/dashboard");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.xpath("//li[@id='menu_news_viewAnnouncementModule']")).click();
        driver.findElement(By.xpath(" //a[@id='menu_news_viewNewsArticles']")).click();

        Map<String,List<String>> news = new HashMap<String, List<String>>();


    }
}

