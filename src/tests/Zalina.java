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

        System.setProperty("webdriver.chrome.driver", "/Users/davidtsutskiridze/Project/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/client/#/dashboard");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.xpath("//li[@id='menu_news_viewAnnouncementModule']")).click();
        driver.findElement(By.xpath(" //a[@id='menu_news_viewNewsArticles']")).click();

        Map<String,List<String>> news = new HashMap<String, List<String>>();
        List<WebElement> topics = driver.findElements(By.xpath("//a[@class='newsTopic']"));
        List<WebElement> dates = driver.findElements(By.xpath("//td[@class=' '][2]"));
        List<WebElement> status = driver.findElements(By.xpath("//td[@class=' hide-on-med-and-down'][1]"));
        List<WebElement> pubLoc = driver.findElements(By.xpath("//td[@class=' hide-on-med-and-down'][2]"));
        List<WebElement> userRoles = driver.findElements(By.xpath("//td[@class=' hide-on-med-and-down'][3]"));
        List<WebElement> attachment = driver.findElements(By.xpath("//i[@class='material-icons attachment disabled handCurser']"));

        for ( int i =0 ; i < topics.size();i++){
           news.put(topics.get(i).getText(), Arrays.asList(dates.get(i).getText(),status.get(i).getText(),
                   pubLoc.get(i).getText(),userRoles.get(i).getText(),attachment.get(i).getText()));
        }

        System.out.println(topics.size());
        System.out.println(dates.size());
        System.out.println(pubLoc.size());
        System.out.println(userRoles.size());
        System.out.println(attachment.size());

        System.out.println(news.keySet().toString());
        driver.quit();

    }


}

