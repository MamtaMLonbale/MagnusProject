package com.qa.TestCases;

import org.testng.annotations.Test;

import com.qa.Pages.CreateEmployee;
import com.qa.Pages.Employee;
import com.qa.Pages.ForgotPassword;
import com.qa.Pages.LaunchJalaSite;
import com.qa.Pages.Login;

import com.qa.Pages.SearchEmployee;
import com.qa.Pages.logout;

public class VerifyJalaAcademy {
	LaunchJalaSite lj = new LaunchJalaSite();
	Login li;
	logout lo;
	Employee e;
	CreateEmployee ce;
	SearchEmployee se;
	ForgotPassword fp;

	@Test(priority = 0)
	public void setup() {
		li = lj.launchSite();
	}

	@Test(priority = 1)
	public void verifyLogin() {
		li.enterUserName();
		li.enterPassword();
		e = li.ClickOnSignIn();
		
	}

	@Test(priority = 2)
	public void verifyEmployee() throws InterruptedException {
		ce = e.clickOnEmployee();
	}

	@Test(priority = 3)
	public void verifyCreate() {
		ce.ClickOncreate();
	}

	@Test(priority = 4)
	public void verifyFirstName() {
		ce.EnterFirstName();
	}

	@Test(priority = 5)
	public void verifyLastName() {
		ce.EnterLastName();
	}

	@Test(priority = 6)
	public void verifyEmailId() {
		ce.EnterEmailid();
	}

	@Test(priority = 7)
	public void verifyMobileNo() {
		ce.EnterMobileNumber();
	}

	@Test(priority = 8)
	public void verifyDOB() {
		ce.EnterDOB();
	}

	@Test(priority = 9)
	public void verifyGender() {
		ce.Selectgender();
	}

	@Test(priority = 10)
	public void verifyAddress() {
		ce.EnterAddress();
	}

	@Test(priority = 11)
	public void verifyCountry() {
		ce.SelectCountry();
	}

	@Test(priority = 12)
	public void verifyCity() throws InterruptedException {
		ce.SelectCity();
	}

	@Test(priority = 13)
	public void verifySkills() {
		ce.SelectSkill();
	}

	@Test(priority = 14)
	public void verifySavebutton() {
		se = ce.clickOnSave();
	}

	@Test(priority = 15)
	public void verifyEmpNameInSearchPage() throws InterruptedException {
		se.enterEmpName();
	}

	@Test(priority = 16)
	public void verifyMobileNoInSearchPage() {
		se.enterMobileNo();
	}

	@Test(priority = 17)
	public void verifySearchButton() {
		se.SearchButton();
	}

	@Test(priority = 18)
	public void verifyClearButton() {
		lo = se.Clear();
	}

	@Test(priority = 19)
	public void verifyMoreFunction() {
		fp = lo.clickOnLogout();

	}

	@Test(priority = 20)
	public void verifyForgotPassword() {
		fp.clickOnForgotPassword();
	}
}