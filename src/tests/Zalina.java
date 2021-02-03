import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zalina {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\VZD\\Desktop\\SELENIUM\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/client/#/dashboard");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.xpath("//li[@id='menu_news_More']")).click();
        driver.findElement(By.xpath(" //a[@id='menu_news_viewNewsArticles']")).click();


    }
}
