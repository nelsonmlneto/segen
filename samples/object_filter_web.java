import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class object_filter {
private static WebDriver driver;
private static String baseUrl;

  @BeforeClass
  public void setUpAll() {
    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    driver = new ChromeDriver();
    baseUrl = "http://localhost:3000/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testObjectFilterAll() {
    driver.get(baseUrl + "/");
    assertTrue(TestHelper.isElementPresent(driver, By.linkText("Air Conditioner")));
    assertTrue(TestHelper.isElementPresent(driver, By.linkText("Clothes Iron")));
    assertTrue(TestHelper.isElementPresent(driver, By.linkText("Hair Straightener")));
    assertTrue(TestHelper.isElementPresent(driver, By.linkText("Couple Bedroom Light")));
    assertTrue(TestHelper.isElementPresent(driver, By.linkText("Oven")));
    assertTrue(TestHelper.isElementPresent(driver, By.linkText("Kitchen Light")));
    assertTrue(TestHelper.isElementPresent(driver, By.linkText("TV")));
    assertTrue(TestHelper.isElementPresent(driver, By.linkText("Garage Light")));
    assertTrue(TestHelper.isElementPresent(By.linkText("Shaving Machine")));
  }

  @Test
  public void testObjectFilterKitchen() {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("//select[@id='rooms-select']/option["+"2"+"]")).click();
    assertTrue(TestHelper.isElementPresent(driver, By.linkText("Oven")));
    assertTrue(TestHelper.isElementPresent(driver, By.linkText("Kitchen Light")));
    assertFalse(TestHelper.isElementPresent(driver, By.linkText("Air Conditioner")));
    assertFalse(TestHelper.isElementPresent(driver, By.linkText("Clothers Iron")));
    assertFalse(TestHelper.isElementPresent(driver, By.linkText("Hair Straightener")));
    assertFalse(TestHelper.isElementPresent(driver, By.linkText("Couple Bedroom Light")));
    assertFalse(TestHelper.isElementPresent(driver, By.linkText("TV")));
    assertFalse(TestHelper.isElementPresent(driver, By.linkText("Garage Light")));
    assertFalse(TestHelper.isElementPresent(driver, By.linkText("Shaving Machine")));
  }

  @Test
  public void testObjectFilterKidsBedroom() {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("//select[@id='rooms-select']/option["+"6"+"]")).click();
    assertFalse(TestHelper.isElementPresent(driver, By.linkText("Air Conditioner")));
    assertFalse(TestHelper.isElementPresent(driver, By.linkText("Clothes Iron")));
    assertFalse(TestHelper.isElementPresent(driver, By.linkText("Hair Straightener")));
    assertFalse(TestHelper.isElementPresent(driver, By.linkText("Couple Bedroom Light")));
    assertFalse(TestHelper.isElementPresent(driver, By.linkText("Oven")));
    assertFalse(TestHelper.isElementPresent(driver, By.linkText("Kitchen Light")));
    assertFalse(TestHelper.isElementPresent(driver, By.linkText("TV")));
    assertFalse(TestHelper.isElementPresent(driver, By.linkText("Garage Light")));
    assertFalse(TestHelper.isElementPresent(driver, By.linkText("Shaving Machine")));
  }

  @AfterClass
  public void tearDownAll() {
    driver.quit();
  }
}