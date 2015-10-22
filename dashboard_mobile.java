import org.openqa.selenium.*;
import io.selendroid.*;
import model.AfterAll;
import model.BeforeAll;
import org.junit.Test;

class dashboard {
private static WebDriver driver;

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
  void testGoalAndConsumedMarch() {

        driver.findElement(By.linkText("March")).click();
        driver.findElement(By.xpath("//AppCompatTextView["+"1"+"]")).click();

        assertEquals("100", driver.findElement(By.id("textGoal")).getText());
        assertEquals("84", driver.findElement(By.id("textConsumed")).getText());
        ;
  }

  @Test
  void testGoalAndConsumedFebruary() {

        driver.findElement(By.linkText("March")).click();
        driver.findElement(By.xpath("//AppCompatTextView["+"2"+"]")).click();

        assertEquals("100", driver.findElement(By.id("goal")).getText());
        assertEquals("89", driver.findElement(By.id("consumed")).getText());
        ;
  }

  @AfterAll
  void tearDownAll() {
    driver.quit();
        ;
  }
}

