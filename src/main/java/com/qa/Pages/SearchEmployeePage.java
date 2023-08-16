package com.qa.Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchEmployeePage extends BaseClass {

	public SearchEmployeePage(WebDriver driver) {
		super(driver);
	}

	public String getSearchPageHeding() {
		WebElement searchPageHeading = driver.findElement(By.xpath("//section//h1"));
		String searchPHeading = searchPageHeading.getText();
		return searchPHeading;
	}

	public String getSearchEmployeeTitle() {
		WebElement searchEmployeeTitle = driver.findElement(By.xpath("//div/h3"));
		String searchTitle = searchEmployeeTitle.getText();
		return searchTitle;
	}

	public void enterEmpName(String empName) throws InterruptedException {
		Thread.sleep(5000);
		WebElement empNameField = driver.findElement(By.name("Name"));
		empNameField.sendKeys(empName);
	}

	public void enterMobileNo(String mobileNo) {
		WebElement mobileNoWebElement = driver.findElement(By.name("MobileNo"));
		mobileNoWebElement.sendKeys(mobileNo);
	}

	public void clickOnSearchButton() {
		WebElement searchButton = driver.findElement(By.id("btnSearch"));
		searchButton.click();
	}

	public EditPage clickOnEditButton() {
		WebElement editButton = driver.findElement(By.xpath("//a[@title='Edit'][1]"));
		editButton.click();
		return new EditPage(driver);
	}

	public void clickOnDeleteButton() throws InterruptedException {
		WebElement editButton = driver.findElement(By.xpath("//a[@title='Edit'][1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4000));
		wait.until(ExpectedConditions.visibilityOf(editButton));
		// Thread.sleep(4000);

		WebElement deleteButton = driver.findElement(By.xpath("//a[@class='btn btn-danger btn-xs'] [1]"));
		deleteButton.click();
	}

	public void getDeleteAlertMassage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.alertIsPresent());
		// Thread.sleep(4000);
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println("Alert message:" + alertMessage);
	}

	public String getEmpName() {
		WebElement empName = driver.findElement(By.xpath("//tbody/tr/td[1]"));
		String firstName = empName.getText();
		System.out.println(firstName);
		return firstName;
	}

	public void getEmpRecords() {
		List<WebElement> records = driver.findElements(By.xpath("//tbody/tr"));
		Iterator<WebElement> itr = records.iterator();
		while (itr.hasNext()) {

			System.out.println(itr.next().getText());
		}
	}

	public String getEmpLastName() {
		WebElement empLast = driver.findElement(By.xpath("//tbody//tr//td[2]"));
		String lastName = empLast.getText();
		return lastName;
	}

	public logout clickOnClearButton() {
		driver.findElement(By.id("btnClear")).click();
		return new logout(driver);
	}

	public String getAttributeNameOfNameField() {
		String attributeName = driver.findElement(By.id("Name")).getText();
		System.out.println("Attribute name of name field-----" + attributeName);
		return attributeName;
	}

	public void clickOnAddEmployeeButton() {
		WebElement addEmployee = driver.findElement(By.xpath("//a[@href='/Employee/Create'][2]"));
		addEmployee.click();
	}
}
