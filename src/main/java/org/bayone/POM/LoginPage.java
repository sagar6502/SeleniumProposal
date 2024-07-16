package org.bayone.POM;

import org.bayone.utils.BaseTest;
import org.bayone.utils.ExtentReportManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginPage extends BaseTest{
	
	private WebDriver driver;

    public LoginPage (WebDriver webDriver){
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }
   
    ExtentTest test;
	
	private By inputEmailId = By.xpath("//input[@id='email']");
	private By inputPw = By.xpath("//input[@id='pw-input']");
//	private By signInButton = By.xpath("//button[@id='sign-in']");
//	private By keepSignInCheckbox = By.xpath("//button[@id='sign-in']");
	
	
	 @FindBy(xpath = "//input[@id='email']")
	 private WebElement emailEnter;
	 
	 @FindBy(xpath = "//input[@id='pw-input']")
	 private WebElement enterPassword;
	 
	 @FindBy(xpath = "//button[@id='sign-in']")
	 private WebElement signInButton;
	 
	 @FindBy(xpath = "//button[@id='sign-in']")
	 private WebElement keepSignInCheckbox;
	 
	 @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
	 private WebElement acceptCookies;
	
	public void loginValidation() throws InterruptedException {
		test = ExtentReportManager.createTest("Sample Test");
		test.log(Status.INFO, "Navigated to Macys.com");
		emailEnter.sendKeys("sagarsunar202@gmail.com");
		test.log(Status.INFO, "Entered Email");
		Thread.sleep(3000);
		enterPassword.sendKeys("User@4321");
		Thread.sleep(3000);
		if(acceptCookies.isEnabled()) {
			acceptCookies.click();
			test.log(Status.INFO, "Accepting Cookies");
		}
		keepSignInCheckbox.click();
		Thread.sleep(3000);
		signInButton.click();
		test.log(Status.PASS, "Successfully Logged In");
	}
}
