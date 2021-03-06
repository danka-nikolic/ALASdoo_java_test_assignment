package com.alasdoo.developercourseassignment.tests.courses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import com.alasdoo.developercourseassignment.dto.DeveloperCourseDTO;
import com.alasdoo.developercourseassignment.dto.StudentDTO;
import com.alasdoo.developercourseassignment.pages.courses.CoursesListPage;
import com.alasdoo.developercourseassignment.tests.FunctionalTest;

public class CoursesListPageTest extends FunctionalTest {
	
	@Test
	public void checkHeaderNames() {
		driver.get(APP_BASE_URL + "/course");
		logger.info("### BROWSER URL: " + driver.getCurrentUrl());

		CoursesListPage courseListPage = new CoursesListPage(driver);
	
		List<WebElement> headerElements = courseListPage.getHeaderElements();

		assertEquals("ID", headerElements.get(0).getText());
		assertEquals("Course name", headerElements.get(1).getText());
		assertEquals("Cost per class", headerElements.get(2).getText());
		assertEquals("Classes per week", headerElements.get(3).getText());

		sleep(3000);
	}

	@Test
	public void checkTableElements() {
		driver.get(APP_BASE_URL + "/course");
		logger.info("### BROWSER URL: " + driver.getCurrentUrl());

		CoursesListPage courseListPage = new CoursesListPage(driver);

		List<DeveloperCourseDTO> courses = courseListPage.readCoursesFromTable();

		int numberOfCoursesOnPage = 10;
		assertEquals(numberOfCoursesOnPage, courses.size());

		DeveloperCourseDTO course1 = courseListPage.findCourseByName("Aliquam gravida mauris");
		if (course1 != null) {
			assertEquals(63, course1.getCostPerClass());
		}

		DeveloperCourseDTO course2 = courseListPage.findCourseByName("Nullam enim. Sed");
		if (course2 != null) {
			assertEquals(67, course2.getCostPerClass());
		}

		sleep(3000);
	}

}
