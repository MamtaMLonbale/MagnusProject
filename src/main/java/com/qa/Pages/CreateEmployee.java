package com.qa.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateEmployee {
	WebDriver driver;
	Select dropdown;

	public CreateEmployee(WebDriver driver) {
		this.driver = driver;
	}

	public void ClickOncreate() {
		driver.findElement(By.xpath("//a[@href='/Employee/Create']")).click();
	}

	public void EnterFirstName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@type='button']"))));
		driver.findElement(By.id("FirstName")).sendKeys("Tom");
	}

	public void EnterLastName() {
		driver.findElement(By.id("LastName")).sendKeys("Peter");
	}

	public void EnterEmailid() {
		driver.findElement(By.id("EmailId")).sendKeys("tom@gmail.com");
	}

	public void EnterMobileNumber() {
		driver.findElement(By.id("MobileNo")).sendKeys("6887457869");
	}

	public void EnterDOB() {
		driver.findElement(By.id("DOB")).sendKeys("12/04/2012");
	}

	public void Selectgender() {
		driver.findElement(By.id("rdbMale")).click();
	}

	public void EnterAddress() {
		driver.findElement(By.name("Address")).sendKeys("Plot No 121, Near Ganpati Temple");
	}

	public void SelectCountry() {
		dropdown = new Select(driver.findElement(By.id("CountryId")));
		dropdown.selectByVisibleText("India");
	}

	public void SelectCity() throws InterruptedException {
		Thread.sleep(3000);
		dropdown = new Select(driver.findElement(By.name("CityId")));
		dropdown.selectByVisibleText("Pune");
	}

	public void SelectSkill() {
		driver.findElement(By.id("chkSkill_1")).click();
	}

	public SearchEmployee clickOnSave() {
		driver.findElement(By.xpath("//button[@type='button']")).click();
		return new SearchEmployee(driver);

	}

	public void cancle() {
		WebElement cancleButton = driver.findElement(By.xpath("//a[contains(text(),'Cancel')]"));
	}
}
