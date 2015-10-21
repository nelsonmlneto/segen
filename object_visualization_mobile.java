import org.openqa.selenium.*;
import io.selendroid.*;
import model.AfterAll;
import model.BeforeAll;
import org.junit.Test;

class object_visualization {
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

        driver.findElement(By.linkText("Air Conditioner")).click();
        assertEquals("Object Visualization", driver.findElement(By.id("labelObjTitle")).getText());
        assertEquals("Air Conditioner", driver.findElement(By.id("textObjName")).getText());
        ;
  }

  @AfterAll
  void tearDownAll() {
    driver.quit();
        ;
  }
}

