
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MyPractice {
    public WebDriver driver = null;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/davidtsutskiridze/Documents/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/auth/login");
    }
    @Test
    public  void test1() throws Exception{
        // login
        driver.findElement(By.id("btnLogin")).click();
        // clicking Admin
        Thread.sleep(2000);
        driver.findElement(By.id("menu_admin_viewAdminModule")).click();
        // clicking Announcements
        driver.findElement(By.xpath("//span[text()='Announcements']")).click();
        //clicking News
        driver.findElement(By.xpath("//span[text()='News']")).click();
        // Map - > printing put the count of news
        Thread.sleep(2000);
        driver.switchTo().frame("noncoreIframe");
        Thread.sleep(2000);
        // Map
        Map<String, List<String>> news = new HashMap<String, List<String>>();
        List<WebElement> topics = driver.findElements(By.xpath("//a[@class='newsTopic']"));
        List<WebElement> dates = driver.findElements(By.xpath("//tr[@class='dataRaw']//td[3]"));
        List<WebElement> pubLoc = driver.findElements(By.xpath("//tr[@class='dataRaw']//td[6]"));
        List<WebElement> attachment = driver.findElements(By.xpath("//tr[@class='dataRaw']//td[7]"));
        // printing part just for me to see result
        int beforeCount = topics.size();
        System.out.println("Before count is: " + beforeCount);
        for (int i = 0; i < topics.size(); i++) {
            news.put(topics.get(i).getText(), Arrays.asList(dates.get(i).getText(),
                    pubLoc.get(i).getText(), attachment.get(i).getText()));
        }
        for (String item : news.keySet()) {
            System.out.println(item + news.get(item));
        }
        // 4. add new news item
//        Thread.sleep(2000);
//        driver.switchTo().frame("news_description_ifr");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//i[@class='large material-icons']")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("formInputText")).sendKeys("Congratulations Batch3");
        Thread.sleep(2000);

        //5,6,7 next btn click
        driver.findElement(By.id("nextBtn")).click();
        Thread.sleep(2000);
        // check "publish to.."
        driver.findElement(By.xpath("//label[@for='news_publish_all']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='input-field col s12 m12 l12'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Publish']")).click();

        // 8,9 -verify

        List<WebElement> topics1 = driver.findElements(By.xpath("//a[@class='newsTopic']"));
        int afterCount = topics1.size();
//        System.out.println("After count is: " + afterCount);
//        System.out.println(beforeCount == afterCount);
        Assert.assertTrue(beforeCount==afterCount,"After count is: " + afterCount);
        // Check they are displayed or not?
        int nOfNews = 0;
//        for (WebElement element : topics1) {
//            if (element.getText().equals("Congratulations Batch3")) {
//                System.out.println("test passed. The text of the news - " + element.getText());
//                nOfNews++;
//            }
//        }
        System.out.println(nOfNews + " is number of the news with the same content");
Assert.assertTrue(nOfNews>0,"test passed. The text of the news");
        //option 2
//        if (driver.findElement(By.xpath("//a[text()='Congratulations Batch3']")).isDisplayed()) {
//            System.out.println("Displayed");
//        } else {
//            System.out.println("Not");
//        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }
}