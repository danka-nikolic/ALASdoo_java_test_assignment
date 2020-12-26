package com.alasdoo.developercourseassignment.pages.courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alasdoo.developercourseassignment.pages.PageObject;

public class CourseEditPage extends PageObject {
	
	@FindBy(xpath = "//*[@id=\"formik-text-field-2\"]")
    private WebElement courseName;

	@FindBy(xpath = "//*[@id=\"formik-text-field-4\"]")
    private WebElement costPerClass;

	@FindBy(xpath = "//*[@id=\"formik-text-field-6\"]")
    private WebElement classPerWeek;

	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[2]/form/div[4]/button[1]")
    private WebElement submitButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[2]/form/div[4]/button[2]")
    private WebElement deleteButton;

	public CourseEditPage(WebDriver driver) {
		super(driver);
	}

	public void changeCourseName(String studentName) {
		courseName.clear();

		courseName.sendKeys(studentName);
	}

	public CoursesListPage clickSubmitButton() {
		submitButton.click();

		return new CoursesListPage(driver);
	}

	public CoursesListPage clickDeleteButton() {
		deleteButton.click();

		return new CoursesListPage(driver);
	}
	
}
