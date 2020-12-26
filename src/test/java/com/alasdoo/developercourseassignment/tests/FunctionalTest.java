package com.alasdoo.developercourseassignment.tests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.checkerframework.common.reflection.qual.GetClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(FunctionalTest.class)
public class FunctionalTest implements TestWatcher {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
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
	
	@Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable) {
		String methodName = extensionContext.getDisplayName().substring(0, extensionContext.getDisplayName().length() - 2);
        captureScreenshot(methodName);
    }

	private static void setupBrowser() throws IOException {
		String browser = System.getProperty("BROWSER_TYPE");

		if (browser == null || browser.isEmpty()) {
			try(InputStream is = FunctionalTest.class.getClassLoader().getResourceAsStream("tests_config.properties")) {
				Properties prop = new Properties();
		        prop.load(is);
		        browser = prop.getProperty("BROWSER");
			}
		}
		
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

		((RemoteWebDriver) driver).setLogLevel(Level.INFO);
	}

	private static void configureMozillaFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
		
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability(CapabilityType.LOGGING_PREFS, getLoggingPreferences());

		driver = new FirefoxDriver(options);
	}

	private static void configureGoogleChromeBrowser() {
		// for Chrome version  87.0.4280.88
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.LOGGING_PREFS, getLoggingPreferences());
		
		driver = new ChromeDriver(options);
	}

	private static void configureInternetExplorerBrowser() {
		System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");

		InternetExplorerOptions options = new InternetExplorerOptions();
        options.setCapability(CapabilityType.LOGGING_PREFS, getLoggingPreferences());

		driver = new InternetExplorerDriver(options);
	}

	private static void configureMicrosoftEdgeBrowser() {
		System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");

		EdgeOptions options = new EdgeOptions();
        options.setCapability(CapabilityType.LOGGING_PREFS, getLoggingPreferences());

		driver = new EdgeDriver(options);
	}
	
	private static LoggingPreferences getLoggingPreferences() {
		LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);

        return logPrefs;
	}
	
	private void captureScreenshot(String fileName) {
        try {
        	LocalTime time = LocalTime.now();
        	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("_HH_mm_ss");
        	String sTime = time.format(dtf);
            new File("src/test/resources/screenshots/").mkdirs(); // Insure directory is there
            FileOutputStream out = new FileOutputStream("src/test/resources/screenshots/" + fileName + sTime + ".png");
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (Exception e) {
        	// TODO - add logger
            e.printStackTrace();
        }
    }
}
