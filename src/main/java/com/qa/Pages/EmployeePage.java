package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeePage extends BaseClass {

	public EmployeePage(WebDriver driver) {
		super(driver);
	}

	public String getCreateText() {

		String createText = driver.findElement(By.xpath("//a[@href='/Employee/Create']")).getText();
		return createText;
	}
}
