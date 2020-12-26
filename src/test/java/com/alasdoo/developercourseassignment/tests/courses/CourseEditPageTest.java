package com.alasdoo.developercourseassignment.tests.courses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.alasdoo.developercourseassignment.pages.courses.CourseEditPage;
import com.alasdoo.developercourseassignment.pages.courses.CoursesListPage;
import com.alasdoo.developercourseassignment.tests.FunctionalTest;

public class CourseEditPageTest extends FunctionalTest {
	
	@Test
	public void checkIfEditingCourseIsOK() {
		driver.get(APP_BASE_URL + "/course/3");
		logger.info("### BROWSER URL: " + driver.getCurrentUrl());

		CourseEditPage courseEditPage = new CourseEditPage(driver);
		
		sleep(3000);

		courseEditPage.changeCourseName("Spring Boot + React");
		
		CoursesListPage coursesListPage = courseEditPage.clickSubmitButton();
		
		sleep(3000);

		assertEquals("Spring Boot + React", coursesListPage.readCoursesFromTable().get(2).getDeveloperCourseName());
		
		sleep(3000);
	}

	@Test
	public void checkIfDeletingCourseIsOK() {
		driver.get(APP_BASE_URL + "/course/5");
		logger.info("### BROWSER URL: " + driver.getCurrentUrl());

		CourseEditPage courseEditPage = new CourseEditPage(driver);
		
		sleep(3000);

		CoursesListPage coursesListPage = courseEditPage.clickDeleteButton();
		
		sleep(3000);

		assertNull(coursesListPage.findCourseById(5));
		
		sleep(3000);
	}

}
