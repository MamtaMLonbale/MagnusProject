package com.qa.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseClass {

	public HomePage(WebDriver driver) {

		super(driver);

	}

	public String getHomePageTitle() {
		WebElement homePageTitle = driver.findElement(By.xpath("//center[@class='pt_100']//following::h1"));
		String hometitle = homePageTitle.getText();
		return hometitle;
	}

	public String getAssignMentText() {
		WebElement assignment = driver.findElement(By.xpath("//center/p/b"));
		String AssignmentText = assignment.getText();
		return AssignmentText;
	}

}
