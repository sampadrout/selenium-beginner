import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestCase {

    private WebDriver driver;

    @BeforeSuite
    public void setiup() {
        String pathToChrome = "/Users/sampadrout/chromedriver";
        System.setProperty("webdriver.chrome.driver", pathToChrome);

        driver = new ChromeDriver();
    }

    @AfterSuite
    public void teardown() {
        driver.close();
    }

    @Test
    public void testOne() {
        driver.navigate().to("http://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();

        String title = driver.findElement(By.cssSelector(".example h2")).getText();
        Assert.assertEquals(title,"Secure Area");
    }
}
