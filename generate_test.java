package com.example.helloworld;

class HelloWorld {
  void Test1() {
    driver.findElement(By.linkText("March")).click();
        driver.findElement(By.xpath("//AppCompatTextView[1]")).click();
        driver.findElement(By.id("roomButton")).click();
        driver.get(baseUrl+"/");
        driver.findElement(By.cssSelector("Ar Condicionado")).click();
        driver.get(baseUrl+"/");


        driver.findElement(By.id("open Button")).click();;
  }
}

