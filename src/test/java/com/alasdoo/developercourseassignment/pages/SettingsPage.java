package com.alasdoo.developercourseassignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	
	public void clickStartButton() {
		startButton.click();
	}

}
