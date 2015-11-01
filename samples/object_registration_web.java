import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class object_registration {
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
  public void testRegisterObject1() {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("buttonAddObj")).click();
    driver.findElement(By.name("serial")).sendKeys("123456");
    driver.findElement(By.name("title")).sendKeys("Washing Machine");
    new Select(driver.findElement(By.id("rooms-modal-select"))).selectByVisibleText("Garage");
    driver.findElement(By.name("description")).sendKeys("The Washing Machine of the Garage");
    driver.findElement(By.id("buttonRegister")).click();
    assertTrue(isElementPresent(By.linkText("Washing Machine")));
  }

  @AfterClass
  public static void tearDownAll() {
    driver.quit();
  }
}

