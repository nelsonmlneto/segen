import org.openqa.selenium.*;
import io.selendroid.*;
import model.AfterAll;
import model.BeforeAll;
import org.junit.Test;

class test {
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
  void Test1() {
    driver.findElement(By.linkText("March")).click();
        driver.findElement(By.xpath("//AppCompatTextView[1]")).click();
        driver.findElement(By.id("roomButton")).click();
        driver.get(baseUrl+"/");

        driver.findElement(By.id("buttonId")).click();
        new Actions(driver).sendKeys(SelendroidKeys.BACK).perform();
        driver.findElement(By.linkText("Objects")).click();
        driver.findElement(By.id("openButton")).click();

        driver.findElement(By.id("open Button")).click();
        ;
  }

  @AfterAll
  void tearDownAll() {
    driver.quit();
        ;
  }
}

