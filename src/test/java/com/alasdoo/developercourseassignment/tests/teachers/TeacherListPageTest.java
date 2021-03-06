package com.alasdoo.developercourseassignment.tests.teachers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;
import com.alasdoo.developercourseassignment.pages.teachers.TeachersListPage;
import com.alasdoo.developercourseassignment.tests.FunctionalTest;

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

		sleep(3000);
	}

	@Test
	public void checkTableElements() {
		driver.get(APP_BASE_URL + "/teacher");
		logger.info("### BROWSER URL: " + driver.getCurrentUrl());

		TeachersListPage teacherListPage = new TeachersListPage(driver);
		
		List<TeacherDTO> teachers = teacherListPage.readTeachersFromTable();

		int numberOfTeachersOnPage = 10;
		assertEquals(numberOfTeachersOnPage, teachers.size());
		
		TeacherDTO teacher = teacherListPage.findTeacherByEmail("justo@tinciduntadipiscingMauris.org");
		if (teacher != null) {
			assertEquals("Floyd", teacher.getTeacherSurname());
		}

		sleep(3000);
	}

}
