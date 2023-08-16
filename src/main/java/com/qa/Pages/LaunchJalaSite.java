package com.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchJalaSite {
	public WebDriver driver = null;
	public LoginPage launchSite() {
		WebDriverManager.chromedriver().driverVersion("109").setup();
		driver = new ChromeDriver();
		driver.get("https://magnus.jalatechnologies.com/");
		driver.manage().window().maximize();
		return new LoginPage(driver);

	}

}
