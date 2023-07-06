package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver;

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUserName() {
		driver.findElement(By.xpath("//input[@class='form-control'][1]")).sendKeys("training@jalaacademy.com");
	}

	public void enterPassword() {
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("jobprogram");
	}

	public Employee ClickOnSignIn() {
		driver.findElement(By.id("btnLogin")).click();
		return new Employee(driver);
	}
}
