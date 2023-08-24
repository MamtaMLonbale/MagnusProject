package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public String getLoginPageHeading()
	{
		WebElement LoginPageHeading=driver.findElement(By.xpath("//div//a/b"));
		String heading=LoginPageHeading.getText();
		return heading;
	}

	public String getLoginPageTitle() {
		String loginPageTitle = driver.getTitle();
		return loginPageTitle;
	}
	public String getRequiredFieldErrorMessage()
	{
		WebElement requiredField=driver.findElement(By.xpath("//div[@class='toast-title']"));
		String errorMessage=requiredField.getText();
		return errorMessage;
	}

	public String getErrorMessageEmailMobileField() {
		WebElement emailFieldErrorMessage = driver
				.findElement(By.xpath("//input[@class='form-control input-validation-error'][1]//following::span[3]"));
		String ErrorMessage = emailFieldErrorMessage.getText();
		return ErrorMessage;
	}

	public String getErrorMessagePasswordField() {
		WebElement passwordfieldErrorMessage = driver
				.findElement(By.xpath("//input[@class='form-control input-validation-error'][1]//following::span[3]"));
		String ErrorMessageforPasswordField = passwordfieldErrorMessage.getText();
		return ErrorMessageforPasswordField;
	}

	public void enterUserName(String username) {
		WebElement userName = driver.findElement(By.xpath("//input[@class='form-control'][1]"));
//		userName.sendKeys("training@jalaacademy.com");

	}

	public void enterPassword(String password) {
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("jobprogram");
	}

	public HomePage clickOnSignInButton() {
		driver.findElement(By.id("btnLogin")).click();
		return new HomePage(driver);
	}
	//
	// public String getHomePageAfterSignIn() {
	// WebElement createPageTitle =
	// driver.findElement(By.xpath("//h1[contains(text(),'Welcome to JALA
	// Academy')]"));
	// String createPagetitle = createPageTitle.getText();
	// return createPagetitle;
	// }

}
