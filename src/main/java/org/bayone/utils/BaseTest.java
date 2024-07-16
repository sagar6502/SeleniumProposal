package org.bayone.utils;

import java.io.IOException;

import org.bayone.POM.LoginPage;
import org.bayone.factory.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	@BeforeClass
    public void setupClass() {
        ExtentReportManager.setup();
    }
	
	 protected static WebDriver driver;
	    protected LoginPage loginPage;

	    public static WebDriver getDriver() {
	        return driver;
	    }

	    public Driver webDriver = new Driver();

	    @BeforeMethod
	    public void preCondition() throws IOException {
	    	driver = webDriver.invokeDriver();
	        driver.manage().window().maximize();
	        driver.get(webDriver.readProperties().getProperty("URL"));
	        loginPage = new LoginPage(driver);
	    }

	    @AfterMethod
	    public void postCondition(){
//	        driver.close();
	    	if (driver != null) {
	            driver.quit();
	        }
	    	System.out.println("Test case completed");
	    }
	    
	    @AfterClass
	    public void tearDownClass() {
	        ExtentReportManager.tearDown();
	    }
}

