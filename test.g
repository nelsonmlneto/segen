
beforeAll begin
    @web begin
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		driver = new ChromeDriver();	  
		baseUrl = "http://localhost:3000/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    end

    @mobile begin
		SelendroidCapabilities capa = new SelendroidCapabilities();
	  	capa.setAut("com.shems.mobile:1.0");	  
      	capa.setPlatformVersion(DeviceTargetPlatform.ANDROID19);     
     	capa.setEmulator(true);
      	capa.setModel("Galaxy Nexus");
  		driver = new SelendroidDriver(capa);
    end
end

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

afterAll begin
	 driver.quit(); 
end