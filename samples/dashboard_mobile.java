import org.openqa.selenium.*;
import io.selendroid.client.*;
import io.selendroid.common.*;
import io.selendroid.common.device.DeviceTargetPlatform;
import org.openqa.selenium.interactions.touch.TouchActions;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class dashboard {
private static WebDriver driver;

  @BeforeClass
  public static void setUpAll() {
    SelendroidCapabilities capa = new SelendroidCapabilities();
    capa.setAut("com.shems.mobile:1.0");
    capa.setPlatformVersion(DeviceTargetPlatform.ANDROID19);
    capa.setEmulator(true);
    capa.setModel("Galaxy Nexus");
    driver = new SelendroidDriver(capa);
  }

  @Test
  public void testGoalAndConsumedMarch() {
    driver.findElement(By.linkText("March")).click();
    driver.findElement(By.xpath("//AppCompatTextView["+"1"+"]")).click();
    assertEquals("100", driver.findElement(By.id("goal")).getText());
    assertEquals("84", driver.findElement(By.id("consumed")).getText());
  }

  @Test
  public void testGoalAndConsumedFebruary() {
    driver.findElement(By.linkText("March")).click();
    driver.findElement(By.xpath("//AppCompatTextView["+"2"+"]")).click();
    assertEquals("100", driver.findElement(By.id("goal")).getText());
    assertEquals("89", driver.findElement(By.id("consumed")).getText());
  }

  @Test
  public void testGoalAndConsumedJanuary() {
    driver.findElement(By.linkText("March")).click();
    driver.findElement(By.xpath("//AppCompatTextView["+"3"+"]")).click();
    assertEquals("100", driver.findElement(By.id("goal")).getText());
    assertEquals("77", driver.findElement(By.id("consumed")).getText());
  }

  @AfterClass
  public static void tearDownAll() {
    driver.quit();
  }
}

