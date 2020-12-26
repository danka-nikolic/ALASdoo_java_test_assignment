package com.alasdoo.developercourseassignment.tests.students;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import com.alasdoo.developercourseassignment.dto.StudentDTO;
import com.alasdoo.developercourseassignment.dto.TeacherDTO;
import com.alasdoo.developercourseassignment.pages.students.StudentsListPage;
import com.alasdoo.developercourseassignment.tests.FunctionalTest;

public class StudentsListPageTest extends FunctionalTest {
	
	@Test
	public void checkHeaderNames() {
		driver.get(APP_BASE_URL + "/student");
		logger.info("### BROWSER URL: " + driver.getCurrentUrl());

		StudentsListPage studentListPage = new StudentsListPage(driver);
		
		List<WebElement> headerElements = studentListPage.getHeaderElements();

		assertEquals("ID", headerElements.get(0).getText());
		assertEquals("Name", headerElements.get(1).getText());
		assertEquals("Surname", headerElements.get(2).getText());
		assertEquals("Account name", headerElements.get(3).getText());
		assertEquals("Email", headerElements.get(4).getText());

		sleep(3000);
	}

	@Test
	public void checkTableElements() {
		driver.get(APP_BASE_URL + "/student");
		logger.info("### BROWSER URL: " + driver.getCurrentUrl());

		StudentsListPage studentListPage = new StudentsListPage(driver);
		
		List<StudentDTO> students = studentListPage.readStudentsFromTable();

		int numberOfStudentsOnPage = 10;
		assertEquals(numberOfStudentsOnPage, students.size());

		StudentDTO student1 = studentListPage.findStudentByEmail("senectus@egestas.net");
		if (student1 != null) {
			assertEquals("Hamilton", student1.getName());
		}

		StudentDTO student2 = studentListPage.findStudentByEmail("elit.pede@necleoMorbi.net");
		if (student2 != null) {
			assertEquals("Kramer", student2.getName());
		}

		sleep(3000);
	}

}
