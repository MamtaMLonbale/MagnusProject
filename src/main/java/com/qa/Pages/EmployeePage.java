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
	// public CreatePage clickOncreate() throws InterruptedException {
	// Thread.sleep(4000);
	// driver.findElement(By.xpath("//a[@href='/Employee/Create']")).click();
	// return new CreatePage(driver);
	// }
}
