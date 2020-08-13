package com.itvdn;

import com.DriverWrapper;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatalogueCoursesPageTest {

    private final DriverWrapper driverWrapper = new DriverWrapper();

    @Before
    public void setUp() {
        driverWrapper.init();
    }

    @After
    public void tearDown() {
        driverWrapper.close();
    }

    @Attachment
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driverWrapper.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Test
    public void openCertainCourse() {
        new CatalogueCoursesPage(driverWrapper.getDriver()).openCertainCourse();
        JavaStarterCoursePage javaStarter = new JavaStarterCoursePage(driverWrapper.getDriver());
        Allure.addAttachment("My Attachment", "Directly, the Attachment itself");
        takeScreenshot();

        assertTrue(javaStarter.getButton().isEnabled());
    }
}
