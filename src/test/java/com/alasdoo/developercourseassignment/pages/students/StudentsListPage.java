package com.alasdoo.developercourseassignment.pages.students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alasdoo.developercourseassignment.dto.StudentDTO;
import com.alasdoo.developercourseassignment.pages.PageObject;

public class StudentsListPage extends PageObject {
	
	@FindBy(className = "MuiDataGrid-colCellTitle")
    private List<WebElement> headerElements;

	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/div")
	private WebElement tableContent;

	public StudentsListPage(WebDriver driver) {
		super(driver);
	}

	public List<WebElement> getHeaderElements() {
		return headerElements;
	}

	public WebElement getTableContent() {
		return tableContent;
	}
	
	public List<StudentDTO> readStudentsFromTable() {
		List<StudentDTO> students = new ArrayList<>();

		String allTableContent = tableContent.getText();
		List<String> tableParts = Arrays.asList(allTableContent.split("\r?\n"));
		
		for (int i=0; i<tableParts.size(); i=i+5) {
			StudentDTO studentDTO = new StudentDTO();

			studentDTO.setId(Integer.valueOf(tableParts.get(i)));
			studentDTO.setName(tableParts.get(i+1));
			studentDTO.setSurname(tableParts.get(i+2));
			studentDTO.setAccountName(tableParts.get(i+3));
			studentDTO.setEmail(tableParts.get(i+4));

			students.add(studentDTO);
		}
		
		return students;
	}
	
	public StudentDTO findStudentById(Integer id) {
		List<StudentDTO> students = readStudentsFromTable();
		
		StudentDTO student = null;

		for (StudentDTO s : students) {
			if (s.getId().equals(id)) {
				student = s;
				break;
			}
		}
		
		return student;
	}

	public StudentDTO findStudentByEmail(String email) {
		List<StudentDTO> students = readStudentsFromTable();
		
		StudentDTO student = null;

		for (StudentDTO s : students) {
			if (s.getEmail().equals(email)) {
				student = s;
				break;
			}
		}
		
		return student;
	}

}
