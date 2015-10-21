import org.openqa.selenium.*;
import io.selendroid.*;
import model.AfterAll;
import model.BeforeAll;
import org.junit.Test;

class object_registration {
  @BeforeAll
  void setUpAll() {
    SelendroidCapabilities capa = new SelendroidCapabilities();
        capa.setAut("com.shems.mobile:1.0");
        capa.setPlatformVersion(DeviceTargetPlatform.ANDROID19);
        capa.setEmulator(true);
        capa.setModel("Galaxy Nexus");
        driver = new SelendroidDriver(capa);
        ;
  }

  @Test
  void testRegisterObject1() {
    driver.findElement(By.linkText("Objects")).click();
        driver.findElement(By.id("buttonAddObj")).click();

        driver.findElement(By.name("serial")).sendKeys("123456");
        driver.findElement(By.name("title")).sendKeys("Washing Machine");
        driver.findElement(By.linkText("Kitchen")).click();
        driver.findElement(By.xpath("//AppCompatTextView[1]")).click();
        driver.findElement(By.name("description")).sendKeys("The Washing Machine of the Garage");
        driver.findElement(By.id("buttonRegister")).click();
        driver.findElement(By.linkText("All")).click();
        driver.findElement(By.xpath("//AppCompatTextView[2]")).click();
        assertTrue(isElementPresent(By.linkText("Washing Machine")));
        ;
  }

  @AfterAll
  void tearDownAll() {
    driver.quit();
        ;
  }
}

