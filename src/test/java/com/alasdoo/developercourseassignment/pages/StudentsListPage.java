package com.alasdoo.developercourseassignment.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentsListPage extends PageObject {
	
	@FindBy(className = "MuiDataGrid-colCellTitle")
    private List<WebElement> headerElements;

	public StudentsListPage(WebDriver driver) {
		super(driver);
	}

	public List<WebElement> getHeaderElements() {
		return headerElements;
	}

	public void setHeaderElements(List<WebElement> headerElements) {
		this.headerElements = headerElements;
	}

}
