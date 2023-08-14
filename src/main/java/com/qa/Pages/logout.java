package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class logout {
	WebDriver driver;

	public logout(WebDriver driver) {
		this.driver = driver;

	}

	public ForgotPassword clickOnLogout() {

		driver.findElement(By.xpath("//span[contains(text(),'Logout')]")).click();
		return new ForgotPassword(driver);

	}

}
