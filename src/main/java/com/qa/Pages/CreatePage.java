package com.qa.Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatePage extends BaseClass {

	Select dropDown;
	// WebElement emailIdWebElement = driver.findElement(By.id("EmailId"));

	public CreatePage(WebDriver driver) {
		super(driver);
	}

	public String getEmployeeDetailsTitle() {
		String employeeDetail = driver.findElement(By.xpath("//div/h3")).getText();
		return employeeDetail;
	}

	public String getEmployeeCreateTitle() {
		String employeeCreate = driver.findElement(By.xpath("//section/h1")).getText();
		return employeeCreate;
	}

	public void enterFirstName(String fname) {
		WebElement FName = driver.findElement(By.id("FirstName"));
		FName.sendKeys(fname);
	}

	public SearchEmployeePage clickOnSaveButton() {
		WebElement cancleButton = driver.findElement(By.xpath("//a[@href='/Employee/Search'][1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOf(cancleButton));
		WebElement saveButton = driver.findElement(By.xpath("//button[@type='button']"));
		saveButton.click();
		return new SearchEmployeePage(driver);
	}

	public SearchEmployeePage clickOnCancle() {
		WebElement cancleButton = driver.findElement(By.xpath("//a[contains(text(),'Cancel')]"));
		cancleButton.click();
		return new SearchEmployeePage(driver);
	}

	public String getFirstNameFieldErrorMessage() {

		WebElement firstName = driver.findElement(By.xpath("//span[@for='FirstName']"));
		String firstNameErrorMessage = firstName.getText();
		return firstNameErrorMessage;
	}

	public void enterLastName(String lastName) {
		WebElement lastNameWebElement = driver.findElement(By.id("LastName"));
		lastNameWebElement.sendKeys(lastName);

	}

	public String getLastNameFieldErrorMessage() {
		WebElement lastName = driver.findElement(By.xpath("//span[@for='LastName']"));
		String lastNameErrorMessage = lastName.getText();
		return lastNameErrorMessage;

	}

	public void enterEmailId(String emailId) {
		WebElement emailIdWebElement = driver.findElement(By.id("EmailId"));
		emailIdWebElement.sendKeys(emailId);

	}

	public String getEmailIdErrorMessage() {
		WebElement emailIdWebElement = driver.findElement(By.xpath("//span[@for='EmailId']"));
		String emailIdfieldErrorMessage = emailIdWebElement.getText();
		System.out.println("Getting Error message for EmialId Empty field-------" + emailIdfieldErrorMessage);
		return emailIdfieldErrorMessage;
	}

	public void enterMobileNumber(String mobileNumber) {
		WebElement contactNumber = driver.findElement(By.id("MobileNo"));
		contactNumber.sendKeys(mobileNumber);

	}

	public String getMobileNumberErrorMessage() {
		WebElement mobileNumberErrorMessage = driver.findElement(By.xpath("//span[@for=\"MobileNo\"]"));
		String MobileErrorMessage = mobileNumberErrorMessage.getText();
		return MobileErrorMessage;
	}

	public void enterDOB(String dateOfBirth) {
		WebElement DOB = driver.findElement(By.id("DOB"));
		DOB.sendKeys(dateOfBirth);
	}

	public void clickOnDOBIcon() {
		WebElement clickOnDOB = driver.findElement(By.className("input-group-addon"));
		clickOnDOB.click();

	}

	public String getMonthYear() {
		WebElement monthYear = driver.findElement(By.xpath("//tr/th[@class='datepicker-switch'][1]"));
		String monthYearText = monthYear.getText();
		return monthYearText;
	}

	public void selectGender(String empGender) {
		WebElement gender = driver.findElement(By.name("rdbGender"));
		if (empGender == "Male") {
			WebElement male = driver.findElement(By.id("rdbMale"));
			male.click();
		} else {
			WebElement female = driver.findElement(By.id("rdbFemale"));
			female.click();
		}
	}

	public void enterAddress(String empAddress) {
		WebElement Address = driver.findElement(By.name("Address"));
		Address.sendKeys(empAddress);
	}

	public void selectCountry(String country) {
		dropDown = new Select(driver.findElement(By.id("CountryId")));
		dropDown.selectByVisibleText(country);
	}

	public String gettingCountryText() {

		WebElement selectedCountryOption = dropDown.getFirstSelectedOption();
		String countryText = selectedCountryOption.getText();
		return countryText;
	}

	public String gettingCity(String city) {
		dropDown = new Select(driver.findElement(By.id("CityId")));
		dropDown.selectByVisibleText(city);
		WebElement selectedCityOption = dropDown.getFirstSelectedOption();
		String cityText = selectedCityOption.getText();
		return cityText;
	}

	public void selectCity(String city) throws InterruptedException {
		Thread.sleep(3000);
		dropDown = new Select(driver.findElement(By.name("CityId")));
		dropDown.selectByVisibleText(city);
	}

	public void SelectSkill(String skill) {

		WebElement skillWebelement = driver.findElement(By.xpath("//div/h4"));
	}

}

// public SaveFunctionality enterInvalidFirstName() {
// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@type='button']"))));
// WebElement invalidFName = driver.findElement(By.id("FirstName"));
// invalidFName.sendKeys("@#$%^^^");
//
