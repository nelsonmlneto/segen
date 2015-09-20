
simple Test1 begin

    @mobile begin
        driver.findElement(By.linkText("March")).click();
        driver.findElement(By.xpath("//AppCompatTextView[1]")).click();
        @clickButton["roomButton"]
    end
    
    @web begin
        driver.get(baseUrl+"/");
        driver.findElement(By.cssSelector("Ar Condicionado")).click();
    end
    
    driver.get(baseUrl+"/");
    
    @openPage[]

    @openButton["buttonId"]
    
    @clickButton["open Button"]

end    

proc openButton [buttonId] begin
	driver.findElement(By.id($buttonId)).click();
    new Actions(driver).sendKeys(SelendroidKeys.BACK).perform();
    driver.findElement(By.linkText("Objects")).click();
    @clickButton["openButton"]
end