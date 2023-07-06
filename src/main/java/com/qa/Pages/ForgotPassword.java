package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassword {
	WebDriver driver;

	public ForgotPassword(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnForgotPassword() {
		driver.findElement(By.xpath("//a[@href='/Account/ForgotPassword']")).click();
	}
}
