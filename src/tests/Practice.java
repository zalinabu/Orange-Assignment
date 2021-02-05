import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

        public class Practice {
            public static void main(String[] args) throws InterruptedException {

                System.setProperty("webdriver.chrome.driver", "C:\\Users\\majid\\Documents\\libs\\chromedriver.exe");

                WebDriver driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

                driver.get("https://orangehrm-demo-6x.orangehrmlive.com/client/#/dashboard");

                //admin login1
                driver.findElement(By.id("btnLogin")).click();

                //admin=announcement=news2
                driver.findElement(By.xpath("//li[@id='menu_news_More']")).click();
                driver.findElement(By.xpath(" //a[@id='menu_news_viewNewsArticles']")).click();
                driver.findElement(By.id("menu_news_viewNewsList")).click();

                driver.switchTo().frame(driver.findElement(By.id("noncoreIframe")));

                List<WebElement> announcements = driver.findElements(By.xpath("//tr[@class='dataRaw']/td[2]"));
                List<WebElement> Data = driver.findElements(By.xpath("//tr[@class='dataRaw']//td[3]"));
                List<WebElement> Role = driver.findElements(By.xpath("//tr[@class='dataRaw']//td[6]"));
                List<WebElement> attachment = driver.findElements(By.xpath("//tr[@class='dataRaw']//td[7]/i"));
                //emplement map3-a.b

                map<String, List<String>> newsList = new LinkedHashMap<>();
                List<String> tempList = new LinkedList<>();

                //attachment
                List<String> fileattachment = new LinkedList<>();
                for(int i = 0; i<fileattachment.size();i++){
                    if(fileattachment.get(i).equals("rgb(201, 201, 201)")){
                        fileattachment.add("empty");
                    }
                }
                //list of items
                for(int i = 0; i < announcements.size();i++){
                    tempList.add(Data.get(i).getText() + Role.get(i).getText() + fileattachment.get(i));

                }







            }

            }










