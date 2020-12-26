package com.alasdoo.developercourseassignment.tests.students;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.alasdoo.developercourseassignment.pages.students.StudentEditPage;
import com.alasdoo.developercourseassignment.pages.students.StudentsListPage;
import com.alasdoo.developercourseassignment.tests.FunctionalTest;

public class StudentEditPageTest extends FunctionalTest {
	
	@Test
	public void checkIfEditingStudentIsOK() {
		driver.get(APP_BASE_URL + "/student/3");
		logger.info("### BROWSER URL: " + driver.getCurrentUrl());

		StudentEditPage studentEditPage = new StudentEditPage(driver);
		
		sleep(3000);

		studentEditPage.changeName("Danka");
		studentEditPage.changeSurname("Nikolic");
		
		StudentsListPage studentsListPage = studentEditPage.clickSubmitButton();
		
		sleep(3000);

		assertEquals("Danka", studentsListPage.readStudentsFromTable().get(2).getName());
		assertEquals("Nikolic", studentsListPage.readStudentsFromTable().get(2).getSurname());
		
		sleep(3000);
	}

	@Test
	public void checkIfDeletingStudentIsOK() {
		driver.get(APP_BASE_URL + "/student/5");
		logger.info("### BROWSER URL: " + driver.getCurrentUrl());

		StudentEditPage studentEditPage = new StudentEditPage(driver);
		
		sleep(3000);

		StudentsListPage studentsListPage = studentEditPage.clickDeleteButton();
		
		sleep(3000);

		assertNull(studentsListPage.findStudentById(5));
		
		sleep(3000);
	}

}
