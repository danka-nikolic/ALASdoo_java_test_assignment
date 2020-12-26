package com.alasdoo.developercourseassignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Base page object for each page
public class PageObject {
	/**
	 * Base logger which is accessible in subclasses
	 */
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	protected WebDriver driver;

	public PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
