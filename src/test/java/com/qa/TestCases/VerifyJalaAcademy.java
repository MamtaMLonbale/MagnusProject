package com.qa.TestCases;

import java.rmi.server.SocketSecurityException;
import javax.sql.rowset.serial.SerialArray;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.Pages.BaseClass;
import com.qa.Pages.CreatePage;
import com.qa.Pages.EditPage;
import com.qa.Pages.EmployeePage;
import com.qa.Pages.HomePage;
import com.qa.Pages.ForgotPassword;
import com.qa.Pages.LaunchJalaSite;
import com.qa.Pages.LoginPage;
import com.qa.Pages.SaveFunctionality;
import com.qa.Pages.SearchEmployeePage;
import com.qa.Pages.logout;

public class VerifyJalaAcademy {
	LaunchJalaSite launchJalaSite = new LaunchJalaSite();
	LoginPage loginPage;
	logout logOut;
	BaseClass baseclass;
	HomePage homePage;
	EmployeePage employeePage;
	CreatePage createPage;
	SaveFunctionality saveButton;
	SearchEmployeePage searchPage;
	EditPage editPage;
	ForgotPassword forgotPassword;
	String employeeFirstName = "ram";

	@Test(priority = 0, alwaysRun = true)
	public void verifySetupFunctionality() {
		loginPage = launchJalaSite.launchSite();
		String actualHeading = loginPage.getLoginPageHeading();
		String expectedHeading = "jala academy";
		Assert.assertEquals(actualHeading, expectedHeading, "incorrect login page heading");
	}

	@Test(priority = 1, alwaysRun = true, dependsOnMethods = { "verifySetupFunctionality" }, dataProvider = "LoginData")
	public void verifyLoginCredential(String userName, String pwd, String exp) {
		System.out.println("Username----" + userName);
		System.out.println("Password----" + pwd);
		System.out.println("Expected----" + exp);
		loginPage.enterUserName(userName);
		loginPage.enterUserName(pwd);
		loginPage.clickOnSignInButton();
		String actualRequiredFieldError = loginPage.getRequiredFieldErrorMessage();
		String expectedErrorMessage = "please fill all the required field";
		Assert.assertEquals(actualRequiredFieldError, expectedErrorMessage, "Incorrect mandatory field error message");
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() {
		String loginData[][] = { { "training@jalaacademy.com", "jobprogram", "valid" },
				{ "train@jalaacademy.com", "jobprogram", "invalid" }, { "training@jalaacademy.com", "job", "invalid" },
				{ "tring@jalaacademy.com", "program", "invalid" } };
		return loginData;
	}

	@Test(priority = 2, dependsOnMethods = { "verifySetupFunctionality()" })
	public void verifyLoginPageTitle() {
		String loginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "login", "Title is incorrect");
	}

	@Test(priority = 3, dependsOnMethods = { "verifySetupFunctionality()" })
	public void verifyErrorMessageEmailMobileField() {
		loginPage.enterPassword("jobprogram");
		loginPage.clickOnSignInButton();
		String actualErrorMessage = loginPage.getErrorMessageEmailMobileField();
		String expectedErrorMessage = "Please enter email or mobile no.";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Email and Mobile Number field is empty");
	}

	@Test(priority = 4, dependsOnMethods = { "verifySetupFunctionality()" })
	public void verifyErrorMessagePasswordField() {
		loginPage.enterUserName("training@jalaacademy.com");
		loginPage.clickOnSignInButton();
		String actualErrorMessageInEmailField = loginPage.getErrorMessagePasswordField();
		String expectedErrorMessageInPasswordField = "Please enter password.";
		Assert.assertEquals(actualErrorMessageInEmailField, expectedErrorMessageInPasswordField,
				"Password field is empty");
	}

	@Test(priority = 5, dependsOnMethods = { "verifySetupFunctionality()" })
	public void verifySignInButton() throws InterruptedException {
		loginPage.enterUserName("training@jalaacademy.com");
		loginPage.enterPassword("jobprogram");
		homePage = loginPage.clickOnSignInButton();
		Thread.sleep(5000);
		String actualHomePageTitle = homePage.getHomePageTitle();
		String expectedHomePageTitle = "Welcome to JALA Academy";
		Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle,
				"Unable to sign in with this login Credentails");
	}

	@Test(priority = 6, dependsOnMethods = { "verifySignInButton" })
	public void verifyAssignmentDeadLine() {
		String actualAssignmentText = homePage.getAssignMentText();
		String expectedAssignmentText = "Do you want to Learn Selenium Automation completely with Practical Scenarios in 7 Days?";
		Assert.assertEquals(actualAssignmentText, expectedAssignmentText, "Incorrect assignment message");
	}

	@Test(priority = 7, dependsOnMethods = { "verifySignInButton" })
	public void verifyCreateText() throws InterruptedException {
		employeePage = homePage.clickOnEmployee();
		Thread.sleep(5000);
		System.out.println("this is clicked on employee");
		String actualCreateTitle = employeePage.getCreateText();
		System.out.println("getting create text");
		String expectedCreateTitle = "create";
		Assert.assertEquals(actualCreateTitle, expectedCreateTitle, "Incorrect create title");
	}

	@Test(priority = 8, alwaysRun = true, dependsOnMethods = { "verifyCreateText" })
	public void verifyEmployeeCreateHeading() throws InterruptedException {
		Thread.sleep(6000);
		createPage = employeePage.clickOncreate();
		Thread.sleep(6000);
		String actualEmployeeCreateTitle = createPage.getEmployeeCreateTitle();
		String expectedEmployeeCreateTitle = "Employee Create";
		Assert.assertEquals(actualEmployeeCreateTitle, expectedEmployeeCreateTitle);
	}

	@Test(priority = 9, alwaysRun = true, dependsOnMethods = { "verifyEmployeeCreateHeading" })
	public void verifyFirstNameFieldErrorMessage() throws InterruptedException {
		createPage.enterFirstName("");
		createPage.clickOnSaveButton();
		String actualFirstNameErrorMessage = createPage.getFirstNameFieldErrorMessage();
		String expectedFirstNameErrorMessage = "Please enter first name";
		Assert.assertEquals(actualFirstNameErrorMessage, expectedFirstNameErrorMessage,
				"Incorrect firstname field error message");
	}

	@Test(priority = 10, dependsOnMethods = { "verifyEmployeeCreateHeading" })
	public void verifyLastNameFieldErrorMessage() throws InterruptedException {
		createPage.enterFirstName("shivam");
		createPage.enterLastName("");
		createPage.clickOnSaveButton();
		String actualLNameErrorMessage = createPage.getLastNameFieldErrorMessage();
		String expectedLNameErrorMessage = "Please enter last name";
		Assert.assertEquals(actualLNameErrorMessage, expectedLNameErrorMessage);
	}

	@Test(priority = 11, dependsOnMethods = { "verifyEmployeeCreateHeading" })
	public void verifyEmailIdEmptyFieldErrormessage() {
		createPage.enterEmailId("");
		createPage.clickOnSaveButton();
		String actualEmailIdErrorMessage = createPage.getEmailIdErrorMessage();
		String ExpectedEmailIdErrorMessage = "Please enter email";
		Assert.assertEquals(actualEmailIdErrorMessage, ExpectedEmailIdErrorMessage,
				"Incorrect email id field error message");
	}

	@Test(priority = 12, dependsOnMethods = { "verifyEmployeeCreateHeading" })
	public void verifyEmailIdFieldInvalidFormatErrorMessage() {
		createPage.enterEmailId("ghjgfhjfkhkgf");
		createPage.clickOnSaveButton();
		String actualEmailIdErrorMessageForWrongFormat = createPage.getEmailIdErrorMessage();
		String expectedEmailIdErrorMessageForWrongFormat = "Please enter valid email address";
		Assert.assertEquals(actualEmailIdErrorMessageForWrongFormat, expectedEmailIdErrorMessageForWrongFormat,
				"Incorrect Email id format");
	}

	@Test(priority = 13, dependsOnMethods = { "verifyEmployeeCreateHeading" })
	public void verifyMobileNumberEmptyField() throws InterruptedException {
		Thread.sleep(5000);
		createPage.enterMobileNumber("");
		createPage.clickOnSaveButton();
		String actualMobileFieldErrorMessage = createPage.getMobileNumberErrorMessage();
		String expectedMobileFieldErrorMessage = "Please enter mobile number.";
		Assert.assertEquals(actualMobileFieldErrorMessage, expectedMobileFieldErrorMessage,
				"Incorrect mobile field error message");
	}

	@Test(priority = 14, dependsOnMethods = { "verifyEmployeeCreateHeading" })
	public void verifyMobileFieldErrorMessageWithAlphabetInput() {
		createPage.enterMobileNumber("WERRTYYGFDFD");
		createPage.clickOnSaveButton();
		String actualErrorMessage = createPage.getMobileNumberErrorMessage();
		String expectedErrorMessage = "Please enter mobile number";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
				"Incorrect error message when i enter alphabet in Mobile field");
	}

	@Test(priority = 15, alwaysRun = true, dependsOnMethods = { "verifyEmployeeCreateHeading" })
	public void verifyCancleButton() throws InterruptedException {
		searchPage = createPage.clickOnCancle();
		String actualHeading = searchPage.getSearchPageHeding();
		String expectedHeading = "employee Search";
		Assert.assertEquals(actualHeading, expectedHeading, "Incorrect employee search page title");

	}

	@Test(priority = 16, dependsOnMethods = { "verifyEmployeeCreateHeading" })
	public void verifySearchEmployeeText() throws InterruptedException {
		createPage.enterFirstName("Bharat");
		createPage.enterLastName("Pande");
		createPage.enterEmailId("bharat@gmail.com");
		createPage.enterMobileNumber("9845566676");
		createPage.enterDOB("13/05/1990");
		createPage.selectGender("Female");
		createPage.enterAddress("Shivaji nagar,Near temple");
		createPage.selectCountry("India");
		createPage.selectCity("Pune");
		createPage.SelectSkill("QA-Automation");
		searchPage = createPage.clickOnSaveButton();
		String actualTitle = searchPage.getSearchEmployeeTitle();
		String expectedtitle = "Search employee";
		Assert.assertEquals(actualTitle, expectedtitle, "Incorrect search employee page title");
	}

	@Test(priority = 17, alwaysRun = true, dependsOnMethods = { "verifyCancleButton" })
	public void verifyListOfRecored() throws InterruptedException {
		Thread.sleep(4000);
		searchPage.enterEmpName(employeeFirstName);
		searchPage.enterMobileNo("9045677854");
		searchPage.clickOnSearchButton();
		Thread.sleep(5000);
		searchPage.getEmpRecords();
	}

	@Test(priority = 18, alwaysRun = true, dependsOnMethods = { "verifyCancleButton" })
	public void verifyEditButton() throws InterruptedException {
		Thread.sleep(4000);
		searchPage.enterEmpName(employeeFirstName);
		searchPage.enterMobileNo("9045677854");
		searchPage.clickOnSearchButton();
		Thread.sleep(5000);
		editPage = searchPage.clickOnEditButton();
		String actualEmpEditHeading = editPage.getEmployeeEditHeading();
		String expectedEmpEditHeading = "Employee edit";
		Assert.assertEquals(actualEmpEditHeading, expectedEmpEditHeading, "Incorrect Edit page heading");
	}

	@Test(priority = 19, alwaysRun = true, dependsOnMethods = { "verifyCancleButton" })
	public void verifyAddemployeeButton() throws InterruptedException {
		searchPage.clickOnAddEmployeeButton();
		createPage = searchPage.clickOncreate();
		String actualEmpDetailsText = createPage.getEmployeeDetailsTitle();
		String expectedEmpDetailsText = "Employee details";
		Assert.assertEquals(actualEmpDetailsText, expectedEmpDetailsText, "Incorrect Employee details Title");
	}

	@Test(priority = 20, alwaysRun = true, dependsOnMethods = { "verifyCancleButton" })
	public void verifyEmployeeFirstName() throws InterruptedException {
		Thread.sleep(4000);
		searchPage.enterEmpName(employeeFirstName);
		searchPage.enterMobileNo("9045677854");
		searchPage.clickOnSearchButton();
		Thread.sleep(4000);
		String actualEmpFirstName = searchPage.getEmpName();
		String expectedEmpFirstName = "ram";
		Assert.assertEquals(actualEmpFirstName, expectedEmpFirstName, "Incorrect employee first Name");
	}

	@Test(priority = 21, alwaysRun = true, dependsOnMethods = { "verifyCancleButton" })
	public void verifyEmployeeLastName() throws InterruptedException {
		Thread.sleep(4000);
		searchPage.enterEmpName(employeeFirstName);
		searchPage.enterMobileNo("9045677854");
		searchPage.clickOnSearchButton();
		Thread.sleep(4000);
		String actualEmpLastName = searchPage.getEmpLastName();
		String expectedEmpLastName = "tiple";
		Assert.assertEquals(actualEmpLastName, expectedEmpLastName, "Incorrect Employee last name");

	}

	@Test(priority = 22, dependsOnMethods = { "verifyEmployeeCreateHeading" })
	public void verifyCountryText() {
		createPage.selectCountry("China");
		String actualCountryText = createPage.gettingCountryText();
		String expectedCountrytext = "Chine";
		Assert.assertEquals(actualCountryText, expectedCountrytext, "Incorrect country name");
	}

}