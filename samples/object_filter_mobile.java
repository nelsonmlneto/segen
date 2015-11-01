import org.openqa.selenium.*;
import io.selendroid.client.*;
import io.selendroid.common.*;
import io.selendroid.common.device.DeviceTargetPlatform;
import org.openqa.selenium.interactions.touch.TouchActions;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class object_filter {
private static WebDriver driver;

  @BeforeClass
  public void setUpAll() {
    SelendroidCapabilities capa = new SelendroidCapabilities();
    capa.setAut("com.shems.mobile:1.0");
    capa.setPlatformVersion(DeviceTargetPlatform.ANDROID19);
    capa.setEmulator(true);
    capa.setModel("Galaxy Nexus");
    driver = new SelendroidDriver(capa);
  }

  @Test
  public void testObjectFilterAll() {
    driver.findElement(By.linkText("Objects")).click();
    assertTrue(TestHelper.isElementPresent(driver, By.linkText("Air Conditioner")));
    assertTrue(TestHelper.isElementPresent(driver, By.linkText("Clothes Iron")));
    assertTrue(TestHelper.isElementPresent(driver, By.linkText("Hair Straightener")));
    assertTrue(TestHelper.isElementPresent(driver, By.linkText("Couple Bedroom Light")));
    assertTrue(TestHelper.isElementPresent(driver, By.linkText("Oven")));
    assertTrue(TestHelper.isElementPresent(driver, By.linkText("Kitchen Light")));
    assertTrue(TestHelper.isElementPresent(driver, By.linkText("TV")));
    assertTrue(TestHelper.isElementPresent(driver, By.linkText("Garage Light")));
    WebElement objList = driver.findElement(By.id("listViewObj"));
    TouchActions touch = new TouchActions(driver).flick(objList, 0, -200, 0);
    touch.perform();
    assertTrue(TestHelper.isElementPresent(By.linkText("Shaving Machine")));
  }

  @Test
  public void testObjectFilterKitchen() {
    driver.findElement(By.linkText("Objects")).click();
    driver.findElement(By.linkText("All")).click();
    driver.findElement(By.xpath("//AppCompatTextView["+"2"+"]")).click();
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
    driver.findElement(By.linkText("Objects")).click();
    driver.findElement(By.linkText("All")).click();
    driver.findElement(By.xpath("//AppCompatTextView["+"6"+"]")).click();

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