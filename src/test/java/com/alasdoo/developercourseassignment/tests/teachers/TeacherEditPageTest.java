package com.alasdoo.developercourseassignment.tests.teachers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.alasdoo.developercourseassignment.pages.teachers.TeacherEditPage;
import com.alasdoo.developercourseassignment.pages.teachers.TeachersListPage;
import com.alasdoo.developercourseassignment.tests.FunctionalTest;

public class TeacherEditPageTest extends FunctionalTest {
	
	@Test
	public void checkIfEditingTeacherIsOK() {
		driver.get(APP_BASE_URL + "/teacher/3");
		logger.info("### BROWSER URL: " + driver.getCurrentUrl());

		TeacherEditPage teacherEditPage = new TeacherEditPage(driver);
		
		sleep(3000);

		teacherEditPage.changeName("Danka");
		teacherEditPage.changeSurname("Nikolic");

		sleep(3000);
		
		TeachersListPage teachersListPage = teacherEditPage.clickSubmitButton();
		
		sleep(3000);

		assertEquals("Danka", teachersListPage.readTeachersFromTable().get(2).getTeacherName());
		assertEquals("Nikolic", teachersListPage.readTeachersFromTable().get(2).getTeacherSurname());
		
		sleep(3000);
	}

	@Test
	public void checkIfDeletingTeacherIsOK() {
		driver.get(APP_BASE_URL + "/teacher/4");
		logger.info("### BROWSER URL: " + driver.getCurrentUrl());

		TeacherEditPage teacherEditPage = new TeacherEditPage(driver);
		
		sleep(3000);

		TeachersListPage teachersListPage = teacherEditPage.clickDeleteButton();
		
		sleep(3000);

		assertNull(teachersListPage.findTeacherById(4));
		
		sleep(3000);
	}

}
