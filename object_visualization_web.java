import org.openqa.selenium.*;
import model.AfterAll;
import model.BeforeAll;
import org.junit.Test;

class object_visualization {
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

