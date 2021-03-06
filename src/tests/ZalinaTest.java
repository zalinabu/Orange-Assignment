import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ZalinaTest {


    @Test
    public void test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/oleksiinikitenko/Desktop/Selenium/chromedriver");

        WebDriver driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/auth/login");
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
        //  System.out.println("Before count is: " + beforeCount);
        for (int i = 0; i < topics.size(); i++) {
            news.put(topics.get(i).getText(), Arrays.asList(dates.get(i).getText(),
                    pubLoc.get(i).getText(), attachment.get(i).getText()));
        }
        for (String item : news.keySet()) {
            //   System.out.println(item + news.get(item));
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
        // printing part just for me
        List<WebElement> topics1 = driver.findElements(By.xpath("//a[@class='newsTopic']"));
        int afterCount = topics1.size();
        // System.out.println("After count is: " + afterCount);
        // System.out.println(beforeCount == afterCount);
        Assert.assertTrue(afterCount == beforeCount + 1);

        // Check they are displayed or not?

        int nOfNews = 0;
        for (WebElement element : topics1) {
            if (element.getText().equals("Congratulations Batch3")) {
                //    System.out.println("test passed. The text of the news - " + element.getText());
                nOfNews++;
            }
        }
        Thread.sleep(2000);
        Assert.assertTrue(nOfNews > 0);
        System.out.println(nOfNews + " is number of the news with the same content");
        //driver.findElement(By.xpath("//div[@class='main-container']//tr[5]//td[2]")).isDisplayed();}}
//option 2
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Congratulations Batch3']")).isDisplayed());
        if (driver.findElement(By.xpath("//a[text()='Congratulations Batch3']")).isDisplayed()) {
            System.out.println("Displayed");
        } else {
            System.out.println("Not");
        }
//10

        driver.findElement(By.id("account-job")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='logoutLink']")).click();
        //  Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn btn-primary dropdown-toggle']")).click();
        // Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@class='login-as'])[4]")).click();
        //news Section
        driver.findElement(By.xpath("//span[text()='Announcements']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='News']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='header']")).click();
        Thread.sleep(3000);

        //  ---- step 13 loging out
        driver.findElement(By.id("account-job")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='logoutLink']")).click();
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("menu_admin_viewAdminModule")).click();
        // clicking Announcements
        driver.findElement(By.xpath("//span[text()='Announcements']")).click();
        //clicking News
        driver.findElement(By.xpath("//span[text()='News']")).click();
        Thread.sleep(2000);
        //            // finding news
        driver.switchTo().frame("noncoreIframe");
        Thread.sleep(2000);


        // finding post and deleting it
        int beforeCount1 = topics1.size();
        System.out.println("Before count is: " + beforeCount1);

        List<WebElement> box = driver.findElements(By.xpath("//a[contains(text(),'Congratulations Batch3')]/ancestor::tr/td"));
        box.get(0).click();
        Thread.sleep(2000);
        //deleting post
        driver.findElement(By.xpath("//a[@id='frmList_ohrmListComponent_Menu']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='newsDelete']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='news-delete-button']")).click();
        Thread.sleep(2000);
        // Verifying item doesnt exist, step 16
        List<WebElement> el = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
        int num2 = 0;
        for (WebElement each : el) {
            if (each.getText().equals("Congratulations Spartans")) {
                num2++;


            }

        }
        Thread.sleep(2000);
        Assert.assertTrue(num2 == 0);
        // Verifying row count step 17
        Thread.sleep(2000);
        List<WebElement> topics2 = driver.findElements(By.xpath("//a[@class='newsTopic']"));
        int afterCount1 = topics2.size();
        System.out.println("After count is: " + afterCount1);
        Assert.assertTrue(beforeCount1-1==afterCount1);
        System.out.println(beforeCount-1 == afterCount);

        driver.quit();
    }
}


