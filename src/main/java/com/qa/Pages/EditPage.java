package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditPage {
	WebDriver driver;
	public EditPage(WebDriver driver) {
	this.driver=driver;
	}
public String getEmployeeEditHeading()
{
	WebElement editHeading=driver.findElement(By.xpath("//h1"));
	String empeditText=editHeading.getText();
	return empeditText;
}
}
