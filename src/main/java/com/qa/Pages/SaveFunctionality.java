package com.qa.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SaveFunctionality {
	WebDriver driver;
	public SaveFunctionality(WebDriver driver) {
		this.driver=driver;
	}
	public void clickOnSaveButton() throws InterruptedException {
//		WebElement cancleButton=driver.findElement(By.xpath("//a[@href='/Employee/Search'][2]"));
//		//WebElement cancleButton=driver.findElement(By.xpath("//a[contains(text(),'Cancel')]"));
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(4000));
//		wait.until(ExpectedConditions.visibilityOf(cancleButton));
		Thread.sleep(5000);
	WebElement saveButton=driver.findElement(By.xpath("//button[@type='button'"));
	saveButton.click();
}
}
