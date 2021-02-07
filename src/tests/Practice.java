import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
        public class Practice {
            public static void main(String[] args) throws InterruptedException {

                System.setProperty("webdriver.chrome.driver", "/Users/davidtsutskiridze/Documents/chromedriver");
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
                System.out.println("Before count is: " + beforeCount);
                for (int i = 0; i < topics.size(); i++){
                    news.put(topics.get(i).getText(), Arrays.asList(dates.get(i).getText(),
                            pubLoc.get(i).getText(),attachment.get(i).getText()));
                }
                for (String item : news.keySet()){
                    System.out.println(item + news.get(item));
                }
                // 4. add new news item
//        Thread.sleep(2000);
//        driver.switchTo().frame("news_description_ifr");
                Thread.sleep(2000);
                driver.findElement(By.xpath("//i[@class='large material-icons']")).click();
                Thread.sleep(2000);
                driver.findElement(By.className("formInputText")).sendKeys("Congratulations  Batch3");
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
                System.out.println("After count is: " + afterCount);
                System.out.println(beforeCount == afterCount);

            }

            }










