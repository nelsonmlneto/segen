import org.openqa.selenium.*;
import io.selendroid.client.*;
import io.selendroid.common.*;
import io.selendroid.common.device.DeviceTargetPlatform;
import org.openqa.selenium.interactions.touch.TouchActions;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class object_visualization {
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
  public void testObjectVisualization1() {
    driver.findElement(By.linkText("Objects")).click();
    driver.findElement(By.linkText("Air Conditioner")).click();
    assertEquals("Object Visualization", driver.findElement(By.id("labelPageTitle")).getText());
    assertEquals("Air Conditioner", driver.findElement(By.id("textObjName")).getText());
  }

  @Test
  public void testObjectVisualization2() {
    driver.findElement(By.linkText("Objects")).click();
    driver.findElement(By.linkText("Clothes Iron")).click();
    assertEquals("Object Visualization", driver.findElement(By.id("labelPageTitle")).getText());
    assertEquals("Clothes Iron", driver.findElement(By.id("textObjName")).getText());
  }

  @Test
  public void testObjectVisualization3() {
    driver.findElement(By.linkText("Objects")).click();
    driver.findElement(By.linkText("Hair Straightener")).click();
    assertEquals("Object Visualization", driver.findElement(By.id("labelPageTitle")).getText());
    assertEquals("Hair Straightener", driver.findElement(By.id("textObjName")).getText());
  }

  @AfterClass
  public static void tearDownAll() {
    driver.quit();
  }
}

