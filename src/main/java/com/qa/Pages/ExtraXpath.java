package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ExtraXpath {
	public WebDriver driver;

	public ExtraXpath(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnEmployee() {
		// WebElement employee=driver.findElement(By.xpath("//nav[@class='navbar
		// navbar-static-top']"));
		// employee.click();

		// driver.findElement(By.className("navbar navbar-static-top")).click();
		// driver.findElement(By.xpath("//span[@class='pull-right-container'][1]")).click();
		// driver.findElement(By.xpath("//li[@class='treeview menu-open']")).click();

		//driver.findElement(By.xpath("//a[@href='#'][1]")).click();
	//driver.findElement(By.xpath("//li/a/i[contains(),' Employee']")).click();
	//driver.findElements(By.xpath("//li/a/i")).get(2).click();
driver.findElement(By.xpath("//a[contains(text(),'http://jalatechnologies.com/contact-us.html')]")).click();
	
WebElement contactusLink = driver
.findElement(By.xpath("//span[contains(text(),'Logout')]"));}

}
//WebElement searchButton=driver.findElement(By.xpath("button[@type='button'][1]"));
	//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(100));
	//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("button[@type='button'][1]"))));
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("button[@type='button'][1]")));
	
	
	//driver.findElement(By.id("Name")).sendKeys("Tom");