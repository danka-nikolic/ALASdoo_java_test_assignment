package com.alasdoo.developercourseassignment.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.alasdoo.developercourseassignment.pages.SettingsPage;

public class SettingsPageTest extends FunctionalTest {
	
    @Test
    public void checkElementsText() {
        driver.get("http://localhost:3000/settings");

        SettingsPage settingsPage = new SettingsPage(driver);
        
        assertEquals("Inject demo content in the backend. Run this command only once!", settingsPage.getDescriptionElementText());
        
        assertEquals("START", settingsPage.getStartButtonText());
    }
	
}