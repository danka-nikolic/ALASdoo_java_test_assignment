package com.alasdoo.developercourseassignment.tests;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FunctionalTest {

	protected static WebDriver driver;

	@BeforeAll
	public static void setUp() throws IOException {
		setupBrowser();
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

	private static void setupBrowser() throws IOException {
		try(InputStream is = FunctionalTest.class.getClassLoader().getResourceAsStream("tests_config.properties")) {
			Properties prop = new Properties();
	        prop.load(is);
	        String browser = prop.getProperty("BROWSER");

	        switch (browser) {
				case "chrome":
					configureGoogleChromeBrowser();
					break;
				case "edge":
					configureMicrosoftEdgeBrowser();
					break;
				case "explorer":
					configureInternetExplorerBrowser();
					break;
				default:
					configureMozillaFirefoxBrowser();
					break;
			}
		}
	}

	private static void configureMozillaFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
		driver = new FirefoxDriver();
	}

	private static void configureGoogleChromeBrowser() {
		// for Chrome version  87.0.4280.88
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}

	private static void configureInternetExplorerBrowser() {
		System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}

	private static void configureMicrosoftEdgeBrowser() {
		System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
		driver = new EdgeDriver();
	}
}
