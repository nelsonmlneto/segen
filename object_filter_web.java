import org.openqa.selenium.*;
import model.AfterAll;
import model.BeforeAll;
import org.junit.Test;

class object_filter {
  @BeforeAll
  void setUpAll() {
    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "http://localhost:3000/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ;
  }

  @Test
  void testObjectFilterAll() {
    driver.get(baseUrl + "/");

        assertTrue(TestHelper.isElementPresent(By.linkText("Air Conditioner")));
        assertTrue(TestHelper.isElementPresent(By.linkText("Clothes Iron")));
        assertTrue(TestHelper.isElementPresent(By.linkText("Hair Straightener")));
        assertTrue(TestHelper.isElementPresent(By.linkText("Couple Bedroom Light")));
        assertTrue(TestHelper.isElementPresent(By.linkText("Oven")));
        assertTrue(TestHelper.isElementPresent(By.linkText("Kitchen Light")));
        assertTrue(TestHelper.isElementPresent(By.linkText("TV")));
        assertTrue(TestHelper.isElementPresent(By.linkText("Garage Light")));
        assertTrue(TestHelper.isElementPresent(By.linkText("Shaving Machine")));
        ;
  }

  @Test
  void testObjectFilterKitchen() {
    driver.get(baseUrl + "/");

        driver.findElement(By.cssSelector("#room-select > option[value="+"2"+"]")).click();

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

