import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class object_visualization {
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
  public void testObjectVisualization1() {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Air Conditioner")).click();
    assertEquals("Object Visualization", driver.findElement(By.id("labelPageTitle")).getText());
    assertEquals("Air Conditioner", driver.findElement(By.id("textObjName")).getText());
  }

  @Test
  public void testObjectVisualization2() {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Clothes Iron")).click();
    assertEquals("Object Visualization", driver.findElement(By.id("labelPageTitle")).getText());
    assertEquals("Clothes Iron", driver.findElement(By.id("textObjName")).getText());
  }

  @Test
  public void testObjectVisualization3() {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Hair Straightener")).click();
    assertEquals("Object Visualization", driver.findElement(By.id("labelPageTitle")).getText());
    assertEquals("Hair Straightener", driver.findElement(By.id("textObjName")).getText());
  }

  @AfterClass
  public static void tearDownAll() {
    driver.quit();
  }
}

