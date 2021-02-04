import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;
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

        driver.switchTo().frame("noncoreIframe");
        Thread.sleep(2000);
        List<WebElement> topics = driver.findElements(By.xpath("//a[@class='newsTopic']"));
        System.out.println("size is: " + topics.size());

        Map<String,List<String>> news = new HashMap<String, List<String>>();
        List<WebElement> topics1 = driver.findElements(By.xpath("//a[@class='newsTopic']"));
        List<WebElement> dates = driver.findElements(By.xpath("//tr[@class='dataRaw']//td[3]"));
        List<WebElement> pubLoc = driver.findElements(By.xpath("//tr[@class='dataRaw']//td[6]"));
        List<WebElement> attachment = driver.findElements(By.xpath("//tr[@class='dataRaw']//td[7]"));
        for (int i = 0; i < topics.size(); i++){
            news.put(topics.get(i).getText(), Arrays.asList(dates.get(i).getText(),
                    pubLoc.get(i).getText(),attachment.get(i).getText()));
        }
        for (String item : news.keySet()){
            System.out.println(item + news.get(item));
        }



    }
}

