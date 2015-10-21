import org.openqa.selenium.*;
import model.AfterAll;
import model.BeforeAll;
import org.junit.Test;

class object_registration {
  @BeforeAll
  void setUpAll() {
    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "http://localhost:3000/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ;
  }

  @Test
  void testRegisterObject1() {
    driver.get(baseUrl + "/");
        driver.findElement(By.id("buttonAddObj")).click();

        driver.findElement(By.name("serial")).sendKeys("123456");
        driver.findElement(By.name("title")).sendKeys("Washing Machine");
        new Select(driver.findElement(By.id("rooms-modal-select"))).selectByVisibleText("Garage");
        driver.findElement(By.name("description")).sendKeys("The Washing Machine of the Garage");
        driver.findElement(By.id("buttonRegister")).click();
        assertTrue(isElementPresent(By.linkText("Washing Machine")));
        ;
  }

  @AfterAll
  void tearDownAll() {
    driver.quit();
        ;
  }
}

