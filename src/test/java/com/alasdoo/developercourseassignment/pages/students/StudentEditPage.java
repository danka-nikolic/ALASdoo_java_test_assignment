package com.alasdoo.developercourseassignment.pages.students;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alasdoo.developercourseassignment.pages.PageObject;

public class StudentEditPage extends PageObject {
	
	@FindBy(xpath = "//*[@id=\"formik-text-field-2\"]")
    private WebElement name;

	@FindBy(xpath = "//*[@id=\"formik-text-field-4\"]")
    private WebElement surname;

	@FindBy(xpath = "//*[@id=\"formik-text-field-6\"]")
    private WebElement accountName;

	@FindBy(xpath = "//*[@id=\"formik-text-field-8\"]")
    private WebElement email;

	@FindBy(xpath = "//*[@id=\"formik-text-field-10\"]")
    private WebElement bankCardNumber;

	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[2]/form/div[7]/button[1]")
    private WebElement submitButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[2]/form/div[7]/button[2]")
    private WebElement deleteButton;

	public StudentEditPage(WebDriver driver) {
		super(driver);
	}

	public void changeName(String studentName) {
		name.clear();

		name.sendKeys(studentName);
	}

	public void changeSurname(String studentSurname) {
		surname.clear();

		surname.sendKeys(studentSurname);
	}

	public StudentsListPage clickSubmitButton() {
		submitButton.click();

		return new StudentsListPage(driver);
	}

	public StudentsListPage clickDeleteButton() {
		deleteButton.click();

		return new StudentsListPage(driver);
	}
	
}
