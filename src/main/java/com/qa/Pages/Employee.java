package com.qa.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Employee {
	WebDriver driver;

	public Employee(WebDriver driver) {
		this.driver = driver;
	}

	public CreateEmployee clickOnEmployee() throws InterruptedException {

		Thread.sleep(5000);
		driver.findElements(By.xpath("//li/a/i")).get(2).click();
		return new CreateEmployee(driver);
	}

}
