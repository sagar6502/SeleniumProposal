package org.bayone.generics;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RFunction {
	
	public void takeFullScreenshot(WebDriver driver) {
		//Capture a whole screenshot and save it as "screenshot.png"
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define the destination path and filename
        String destinationPath = "src/ImportantFiles/screenshot1.png";

        // Copy the screenshot file to the destination path
        try {
            FileUtils.copyFile(screenshotFile, new File(destinationPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public void takePartialScreenshot(WebElement element) {
		File screenshotFile = element.getScreenshotAs(OutputType.FILE);

        // Define the destination path and filename
        String destinationPath = "src/ImportantFiles/Partialscreenshot1.png";

        // Copy the screenshot file to the destination path
        try {
            FileUtils.copyFile(screenshotFile, new File(destinationPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public void takePartialScreenshotofMultipleElements(List<WebElement> elements) {
		int i=0;
		for(WebElement element: elements) {
			File screenshotFile = element.getScreenshotAs(OutputType.FILE);

	        // Define the destination path and filename
	        String destinationPath = "src/ImportantFiles/Partialscreenshot"+i+".png";
	        i++;
	        // Copy the screenshot file to the destination path
	        try {
	            FileUtils.copyFile(screenshotFile, new File(destinationPath));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
	}
	
	public int countLink(WebDriver driver) {
		int count= driver.findElements(By.tagName("a")).size();
		return count;
	}
	
	
	/*
	public void windowSecurityPopupOS() throws IOException, InterruptedException {
		Process process = Runtime.getRuntime().exec("D:\\Downloads\\autoit-v3-setup");
		process.wait();
	}
	*/
}
