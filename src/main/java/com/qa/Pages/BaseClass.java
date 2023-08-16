package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseClass {
	WebDriver driver = null;

	public BaseClass(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage clickOnHome() {
		WebElement home = driver.findElement(By.xpath("//a[@href='/Home/Index']"));
		home.click();
		return new HomePage(driver);
	}

	public EmployeePage clickOnEmployee() throws InterruptedException {
		Thread.sleep(5000);
		WebElement employee = driver.findElements(By.xpath("//li/a/i")).get(2);
		employee.click();
		return new EmployeePage(driver);

	}
	
	public CreatePage clickOncreate() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@href='/Employee/Create']")).click();
		return new CreatePage(driver);
	}

	public SearchEmployeePage clickOnSearch()
	{
		driver.findElement(By.xpath("//a[@href='/Employee/Search']"));
		return new SearchEmployeePage(driver);
	}
}
