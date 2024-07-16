package org.bayone.generics;

import org.bayone.factory.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class SagarGenericLib {

	public static Driver webDriver = new Driver();
	public static WebDriver driver = webDriver.invokeDriver();
	RFunction reuseFunc = new RFunction();
	
	public void launchURL(String link) {
		System.out.println(link);
		driver.get(link);
		Assert.assertEquals(driver.getCurrentUrl(), link);
	}
	
	public void takeFullScreenShot(){
		reuseFunc.takeFullScreenshot(driver);
		
	}
	
	
	public void closeDriver() {
		driver.close();
	}
	
}
