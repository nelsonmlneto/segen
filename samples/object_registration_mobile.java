import org.openqa.selenium.*;
import io.selendroid.client.*;
import io.selendroid.common.*;
import io.selendroid.common.device.DeviceTargetPlatform;
import org.openqa.selenium.interactions.touch.TouchActions;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class object_registration {
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
  public void testRegisterObject1() {
    driver.findElement(By.linkText("Objects")).click();
    driver.findElement(By.id("buttonAddObj")).click();
    driver.findElement(By.name("serial")).sendKeys("123456");
    driver.findElement(By.name("title")).sendKeys("Washing Machine");
    driver.findElement(By.linkText("Kitchen")).click();
    driver.findElement(By.xpath("//AppCompatTextView[6]")).click();
    driver.findElement(By.name("description")).sendKeys("The Washing Machine of the Garage");
    driver.findElement(By.id("buttonRegister")).click();
    assertTrue(isElementPresent(By.linkText("Washing Machine")));
  }

  @AfterClass
  public static void tearDownAll() {
    driver.quit();
  }
}

