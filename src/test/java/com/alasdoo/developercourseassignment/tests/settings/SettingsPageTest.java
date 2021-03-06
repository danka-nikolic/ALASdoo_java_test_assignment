package com.alasdoo.developercourseassignment.tests.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.alasdoo.developercourseassignment.pages.settings.SettingsPage;
import com.alasdoo.developercourseassignment.tests.FunctionalTest;

public class SettingsPageTest extends FunctionalTest {
	
    @Test
    public void checkElementsText() {
        driver.get(APP_BASE_URL + "/settings");
        logger.info("### BROWSER URL: " + driver.getCurrentUrl());

        SettingsPage settingsPage = new SettingsPage(driver);
        
        assertEquals("Inject demo content in the backend. Run this command only once!", settingsPage.getDescriptionElementText());
        
        assertEquals("START", settingsPage.getStartButtonText());

        sleep(3000);
    }
	
}
