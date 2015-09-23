import org.openqa.selenium.*;
import model.AfterAll;
import model.BeforeAll;
import org.junit.Test;

class test {
  @BeforeAll
  void setUpAll() {
    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "http://localhost:3000/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ;
  }

  @Test
  void Test1() {
    driver.get(baseUrl+"/");
        driver.findElement(By.cssSelector("Ar Condicionado")).click();
        driver.get(baseUrl+"/");
        driver.get(baseUrl+"/1");
        driver.get(baseUrl+"/2");

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

