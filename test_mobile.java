class test {
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
}

