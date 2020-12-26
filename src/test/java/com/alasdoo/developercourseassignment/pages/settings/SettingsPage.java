package com.alasdoo.developercourseassignment.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alasdoo.developercourseassignment.pages.PageObject;

// Encapsulates /settings page
public class SettingsPage extends PageObject {
	
	@FindBy(tagName = "p")
    private WebElement descriptionElement;
	
	@FindBy(tagName = "Button")
    private WebElement startButton;

	public SettingsPage(WebDriver driver) {
		super(driver);
	}
	
	public String getDescriptionElementText() {
		return descriptionElement.getText();
	}
	
	public String getStartButtonText() {
		return startButton.getText();
	}
	
	/**
	 * Method which clicks start button on settings page
	 */
	public void clickStartButton() {
		startButton.click();
	}

}
