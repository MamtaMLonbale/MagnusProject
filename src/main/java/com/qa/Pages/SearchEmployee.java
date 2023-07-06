package com.qa.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchEmployee {
	WebDriver driver;
public SearchEmployee(WebDriver driver) {
	this.driver=driver;
}
public void enterEmpName() throws InterruptedException
{
	Thread.sleep(5000);
	
	driver.findElement(By.name("Name")).sendKeys("Tom Peter");
}
public void enterMobileNo()
{
	driver.findElement(By.name("MobileNo")).sendKeys("6887457869");
	
}
public void SearchButton()
{
	driver.findElement(By.id("btnSearch")).click();
	
}
public logout Clear()
{
	driver.findElement(By.id("btnClear")).click();
	return new logout(driver);
}

}
