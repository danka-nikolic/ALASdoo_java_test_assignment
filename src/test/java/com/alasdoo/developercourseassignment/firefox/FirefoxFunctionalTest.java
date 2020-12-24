package com.alasdoo.developercourseassignment.firefox;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxFunctionalTest {
	protected static WebDriver driver;

	@BeforeAll
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterEach
	public void cleanUp() {
		driver.manage().deleteAllCookies();
	}

	@AfterAll
	public static void tearDown() {
		driver.close();
	}

}
