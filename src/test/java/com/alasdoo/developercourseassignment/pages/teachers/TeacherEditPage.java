package com.alasdoo.developercourseassignment.pages.teachers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alasdoo.developercourseassignment.pages.PageObject;

public class TeacherEditPage extends PageObject {
	
	@FindBy(xpath = "//*[@id=\"formik-text-field-2\"]")
    private WebElement name;

	@FindBy(xpath = "//*[@id=\"formik-text-field-4\"]")
    private WebElement surname;

	@FindBy(xpath = "//*[@id=\"formik-text-field-6\"]")
    private WebElement email;

	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[2]/form/div[5]/button[1]")
    private WebElement submitButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[2]/form/div[5]/button[2]")
    private WebElement deleteButton;

	public TeacherEditPage(WebDriver driver) {
		super(driver);
	}

	public void changeName(String teacherName) {
		name.clear();

		name.sendKeys(teacherName);
	}

	public void changeSurname(String teacherSurname) {
		surname.clear();

		surname.sendKeys(teacherSurname);
	}

	public TeachersListPage clickSubmitButton() {
		submitButton.click();

		return new TeachersListPage(driver);
	}

	public TeachersListPage clickDeleteButton() {
		deleteButton.click();

		return new TeachersListPage(driver);
	}
	
}
