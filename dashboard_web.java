import org.openqa.selenium.*;
import model.AfterAll;
import model.BeforeAll;
import org.junit.Test;

class dashboard {
private static WebDriver driver;
private static String baseUrl;

  @BeforeAll
  void setUpAll() {
    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "http://localhost:3000/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ;
  }

  @Test
  void testGoalAndConsumedMarch() {
    driver.get(baseUrl + "/");

        driver.findElement(By.cssSelector("#month-select > option[value="+"1"+"]")).click();

        assertEquals("100", driver.findElement(By.id("textGoal")).getText());
        assertEquals("84", driver.findElement(By.id("textConsumed")).getText());
        ;
  }

  @Test
  void testGoalAndConsumedFebruary() {
    driver.get(baseUrl + "/");

        driver.findElement(By.cssSelector("#month-select > option[value="+"2"+"]")).click();

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

