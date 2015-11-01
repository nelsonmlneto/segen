import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class dashboard {
private static WebDriver driver;
private static String baseUrl;

  @BeforeClass
  public static void setUpAll() {
    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    driver = new ChromeDriver();
    baseUrl = "http://localhost:3000/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testGoalAndConsumedMarch() {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("//select[@id='month-select']/option["+"1"+"]")).click();
    assertEquals("100", driver.findElement(By.id("goal")).getText());
    assertEquals("84", driver.findElement(By.id("consumed")).getText());
  }

  @Test
  public void testGoalAndConsumedFebruary() {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("//select[@id='month-select']/option["+"2"+"]")).click();
    assertEquals("100", driver.findElement(By.id("goal")).getText());
    assertEquals("89", driver.findElement(By.id("consumed")).getText());
  }

  @Test
  public void testGoalAndConsumedJanuary() {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("//select[@id='month-select']/option["+"3"+"]")).click();
    assertEquals("100", driver.findElement(By.id("goal")).getText());
    assertEquals("77", driver.findElement(By.id("consumed")).getText());
  }

  @AfterClass
  public static void tearDownAll() {
    driver.quit();
  }
}

