class test {
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
}

