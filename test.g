
simple Test1 begin

    @mobile begin
        driver.findElement(By.linkText("March")).click();
        driver.findElement(By.xpath("//AppCompatTextView[1]")).click();
    end
    
    @web begin
        driver.get(baseUrl+"/");
        driver.findElement(By.cssSelector("option[value='1']")).click();
    end
    
    driver.get(baseUrl+"/");
    
    @openPage["buttonId"]
    
    @clickButton["openButton"]

end    

proc openButton [buttonId] begin
	driver.findElement(By.id($buttonId)).click();
end