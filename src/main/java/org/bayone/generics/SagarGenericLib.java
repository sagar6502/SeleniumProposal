package org.bayone.generics;

import java.io.IOException;
import java.time.Duration;

import org.bayone.factory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class SagarGenericLib {

	public static Driver webDriver = new Driver();
	public static WebDriver driver ;
	RFunction reuseFunc = new RFunction();
	
	
	public void launchURL() throws IOException {

		driver = webDriver.invokeDriver();
		String link = webDriver.readProperties().getProperty("URL");
		System.out.println(link);
		driver.get(link);
		Assert.assertEquals(driver.getCurrentUrl(), link);
	}
	
	public void bookFlight() throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='Select Destination']")).sendKeys("HYD");
		Thread.sleep(5000);
		WebElement CalendarScope = driver.findElement(By.xpath(""));
		//div[contains(@data-testid,'September-2023')]
	}
	
	public void scrapJWT() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Actions action = new Actions(driver);
		WebElement text = driver.findElement(By.xpath("(//div[@class='CodeMirror-sizer'])[2]"));
		String value = text.getText();
		wait.until(ExpectedConditions.visibilityOf(text));
		action.keyDown(text, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		action.sendKeys(Keys.BACK_SPACE).perform();
		action.sendKeys(text, value).build().perform();
	}
	
	public void takeFullScreenShot(){
		reuseFunc.takeFullScreenshot(driver);
		
	}
	
	public void takeMakeMyTrip(){
		driver.findElement(By.xpath("(//input[@id='username'])[1]")).sendKeys("sagarsunar202@gmail.com");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER);
	}
	
	public void useAutoIt() throws InterruptedException, IOException {
		WebElement upload = 
				driver.findElement(By.xpath("//div[@class='sc-2xfn8l-0 bWaBkl sc-2wite4-0 itDlvX']"));
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.click(upload).perform();
		Thread.sleep(3000);
		Runtime.getRuntime()
		.exec("D:\\SeleniumLearning\\SeleniumFramework\\src\\main\\resources\\FileUploadScript.exe");
		Thread.sleep(3000);
		int count = driver.findElements(By.xpath("//div[@class='sc-28hkba-0 hUQUA']")).size();
		Assert.assertEquals(count, 1);
		System.out.print("File uploaded successfully");
	}
	
	public void useAutoIt_New() throws InterruptedException, IOException {
		WebElement upload = 
				driver.findElement(By.xpath("//div[@class='sc-2xfn8l-0 bWaBkl sc-2wite4-0 itDlvX']"));
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.click(upload).perform();
		Thread.sleep(3000);
		Runtime.getRuntime()
		.exec("D:\\SeleniumLearning\\SeleniumFramework\\src\\main\\resources\\FileUploadScript.exe");
		Thread.sleep(3000);
		int count = driver.findElements(By.xpath("//div[@class='sc-28hkba-0 hUQUA']")).size();
		Assert.assertEquals(count, 1);
		System.out.print("File uploaded successfully");
	}
	
	
	
	public void closeDriver() {
		driver.close();
	}
	
}
