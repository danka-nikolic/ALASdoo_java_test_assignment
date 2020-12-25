package com.alasdoo.developercourseassignment.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import com.alasdoo.developercourseassignment.pages.StudentsListPage;

public class StudentsListPageTest extends FunctionalTest {
	
	@Test
	public void checkHeaderNames() {
		driver.get("http://localhost:3000/student");

		StudentsListPage studentListPage = new StudentsListPage(driver);
		
		List<WebElement> headerElements = studentListPage.getHeaderElements();

		assertEquals("ID", headerElements.get(0).getText());
		assertEquals("Name", headerElements.get(1).getText());
		assertEquals("Surname", headerElements.get(2).getText());
		assertEquals("Account name", headerElements.get(3).getText());
		assertEquals("Email", headerElements.get(4).getText());
	}

}
