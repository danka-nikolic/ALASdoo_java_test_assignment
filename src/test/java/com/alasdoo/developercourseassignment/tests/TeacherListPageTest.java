package com.alasdoo.developercourseassignment.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;
import com.alasdoo.developercourseassignment.pages.TeachersListPage;

public class TeacherListPageTest extends FunctionalTest {
	
	@Test
	public void checkHeaderNames() {
		driver.get(APP_BASE_URL + "/teacher");
		logger.info("### BROWSER URL: " + driver.getCurrentUrl());

		TeachersListPage teacherListPage = new TeachersListPage(driver);
		
		List<WebElement> headerElements = teacherListPage.getHeaderElements();

		assertEquals("ID", headerElements.get(0).getText());
		assertEquals("Name", headerElements.get(1).getText());
		assertEquals("Surname", headerElements.get(2).getText());
	}

	@Test
	public void checkTableElements() {
		driver.get(APP_BASE_URL + "/teacher");
		logger.info("### BROWSER URL: " + driver.getCurrentUrl());

		TeachersListPage teacherListPage = new TeachersListPage(driver);
		
		List<TeacherDTO> teachers = teacherListPage.readTeachersFromTable();

		int numberOfTeachersOnPage = 10;
		assertEquals(numberOfTeachersOnPage, teachers.size());
		
		assertEquals("Linda", teachers.get(3).getTeacherName());

		assertEquals("Daniels", teachers.get(8).getTeacherSurname());
	}

}
