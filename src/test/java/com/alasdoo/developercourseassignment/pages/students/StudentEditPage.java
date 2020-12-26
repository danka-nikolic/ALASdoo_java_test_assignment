package com.alasdoo.developercourseassignment.pages.students;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alasdoo.developercourseassignment.pages.PageObject;

public class StudentEditPage extends PageObject {
	
	@FindBy(name = "name")
    private WebElement name;

	@FindBy(name = "surname")
    private WebElement surname;

	@FindBy(name = "accountName")
    private WebElement accountName;

	@FindBy(name = "email")
    private WebElement email;

	@FindBy(name = "bankCardNumber")
    private WebElement bankCardNumber;

	@FindBy(name = "SubmitButton")
    private WebElement submitButton;

	@FindBy(name = "Button")
    private WebElement deleteButton;

	public StudentEditPage(WebDriver driver) {
		super(driver);
	}
}
