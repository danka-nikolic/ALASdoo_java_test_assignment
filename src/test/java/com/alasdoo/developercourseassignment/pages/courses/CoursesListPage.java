package com.alasdoo.developercourseassignment.pages.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.alasdoo.developercourseassignment.dto.DeveloperCourseDTO ;
import com.alasdoo.developercourseassignment.dto.TeacherDTO;
import com.alasdoo.developercourseassignment.pages.PageObject;

public class CoursesListPage extends PageObject {
	
	@FindBy(className = "MuiDataGrid-colCellTitle")
    private List<WebElement> headerElements;

	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/div/div[2]/div[2]/div/div/div")
	private WebElement tableContent;

	public CoursesListPage(WebDriver driver) {
		super(driver);
	}
	
	public List<WebElement> getHeaderElements() {
		return headerElements;
	}

	public WebElement getTableContent() {
		return tableContent;
	}
	
	public List<DeveloperCourseDTO> readCoursesFromTable() {
		List<DeveloperCourseDTO > courses = new ArrayList<>();

		String allTableContent = tableContent.getText();
		List<String> tableParts = Arrays.asList(allTableContent.split("\r?\n"));
		
		for (int i=0; i<tableParts.size(); i=i+4) {
			DeveloperCourseDTO courseDTO = new DeveloperCourseDTO ();

			courseDTO.setId(Integer.valueOf(tableParts.get(i)));
			courseDTO.setDeveloperCourseName(tableParts.get(i+1));
			courseDTO.setCostPerClass(readCostPerClass(tableParts.get(i+2)));
			courseDTO.setClassesPerWeek(Integer.valueOf(tableParts.get(i+3)));

			courses.add(courseDTO);
		}
		
		return courses;
	}
	
	public DeveloperCourseDTO findCourseById(Integer id) {
		List<DeveloperCourseDTO> courses = readCoursesFromTable();
		
		DeveloperCourseDTO course = null;

		for (DeveloperCourseDTO dc : courses) {
			if (dc.getId().equals(id)) {
				course = dc;
				break;
			}
		}
		
		return course;
	}

	private Integer readCostPerClass(String sCost) {
		String[] splited = sCost.split("\\s+");
		Double dCost = Double.valueOf(splited[0].replace(",", "."));

		return dCost.intValue();
	}
	
}
