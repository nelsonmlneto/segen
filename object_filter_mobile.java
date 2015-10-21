import org.openqa.selenium.*;
import io.selendroid.*;
import model.AfterAll;
import model.BeforeAll;
import org.junit.Test;

class object_filter {
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
  void testObjectFilterAll() {
    driver.findElement(By.linkText("Objects")).click();

        assertTrue(TestHelper.isElementPresent(By.linkText("Air Conditioner")));
        assertTrue(TestHelper.isElementPresent(By.linkText("Clothes Iron")));
        assertTrue(TestHelper.isElementPresent(By.linkText("Hair Straightener")));
        assertTrue(TestHelper.isElementPresent(By.linkText("Couple Bedroom Light")));
        assertTrue(TestHelper.isElementPresent(By.linkText("Oven")));
        assertTrue(TestHelper.isElementPresent(By.linkText("Kitchen Light")));
        assertTrue(TestHelper.isElementPresent(By.linkText("TV")));
        assertTrue(TestHelper.isElementPresent(By.linkText("Garage Light")));
        WebElement objList = driver.findElement(By.id("listViewObj"));
        TouchActions touch = new TouchActions(driver).flick(objList, 0, -200, 0);
        touch.perform();
        assertTrue(TestHelper.isElementPresent(By.linkText("Shaving Machine")));
        ;
  }

  @Test
  void testObjectFilterKitchen() {
    driver.findElement(By.linkText("Objects")).click();

        driver.findElement(By.linkText("All")).click();
        driver.findElement(By.xpath("//AppCompatTextView["+"2"+"]")).click();

        assertTrue(TestHelper.isElementPresent(By.linkText("Hair Straightener")));
        assertTrue(TestHelper.isElementPresent(By.linkText("Shaving Machine")));
        assertFalse(TestHelper.isElementPresent(By.linkText("Air Conditioner")));
        assertFalse(TestHelper.isElementPresent(By.linkText("Clothers Iron")));
        assertFalse(TestHelper.isElementPresent(By.linkText("Couple Bedroom Light")));
        assertFalse(TestHelper.isElementPresent(By.linkText("Oven")));
        assertFalse(TestHelper.isElementPresent(By.linkText("Kitchen Light")));
        assertFalse(TestHelper.isElementPresent(By.linkText("TV")));
        assertFalse(TestHelper.isElementPresent(By.linkText("Garage Light")));
        ;
  }

  @AfterAll
  void tearDownAll() {
    driver.quit();
        ;
  }
}

