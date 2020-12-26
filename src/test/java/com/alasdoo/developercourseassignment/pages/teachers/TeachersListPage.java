package com.alasdoo.developercourseassignment.pages.teachers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;
import com.alasdoo.developercourseassignment.pages.PageObject;

public class TeachersListPage extends PageObject {
	
	@FindBy(className = "MuiDataGrid-colCellTitle")
    private List<WebElement> headerElements;

	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/div/div[2]/div[2]/div/div/div")
	private WebElement tableContent;

	public TeachersListPage(WebDriver driver) {
		super(driver);
	}

	public List<WebElement> getHeaderElements() {
		return headerElements;
	}

	public WebElement getTableContent() {
		return tableContent;
	}
	
	public List<TeacherDTO> readTeachersFromTable() {
		List<TeacherDTO> teachers = new ArrayList<>();

		String allTableContent = tableContent.getText();
		List<String> tableParts = Arrays.asList(allTableContent.split("\r?\n"));
		
		for (int i=0; i<tableParts.size(); i=i+3) {
			TeacherDTO teacherDTO = new TeacherDTO();

			teacherDTO.setId(Integer.valueOf(tableParts.get(i)));
			teacherDTO.setTeacherName(tableParts.get(i+1));
			teacherDTO.setTeacherSurname(tableParts.get(i+2));

			teachers.add(teacherDTO);
		}
		
		return teachers;
	}

	public TeacherDTO findTeacherById(Integer id) {
		List<TeacherDTO> teachers = readTeachersFromTable();
		
		TeacherDTO teacher = null;

		for (TeacherDTO t : teachers) {
			if (t.getId().equals(id)) {
				teacher = t;
				break;
			}
		}
		
		return teacher;
	}

	public TeacherDTO findTeacherByEmail(String email) {
		List<TeacherDTO> teachers = readTeachersFromTable();
		
		TeacherDTO teacher = null;

		for (TeacherDTO t : teachers) {
			if (t.getTeacherEmail().equals(email)) {
				teacher = t;
				break;
			}
		}
		
		return teacher;
	}
}
