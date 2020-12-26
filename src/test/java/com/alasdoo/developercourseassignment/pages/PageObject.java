package com.alasdoo.developercourseassignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageObject {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	protected WebDriver driver;

	public PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
