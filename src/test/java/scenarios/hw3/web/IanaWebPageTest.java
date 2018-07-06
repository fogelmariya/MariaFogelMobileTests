package scenarios.hw3.web;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.web.HomePage;

import static enums.driverSetup.TestsSettingsEnum.WEB_PROPERTY;
import static enums.web.SitePageEnum.HOME_PAGE_TITLE;
import static setup.DriverSetup.getDriver;
import static setup.DriverSetup.getUrl;
import static setup.DriverSetup.prepareDriver;

public class IanaWebPageTest {
    HomePage homePage;

    /**
     * prepare AppiumDriver
     */
    @BeforeClass(alwaysRun = true)
    public void setup() {
        try {
            prepareDriver(WEB_PROPERTY.text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getDriver().get(getUrl());
        homePage = new HomePage();
    }

    /**
     * close resources
     */
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        getDriver().closeApp();
    }

    /**
     * checking some functional on web site "https://www.iana.org".
     */
    @Test(description = "testing of web site", groups = "web")
    public void checkPageContent() {
        //check title
        homePage.checkUrl(HOME_PAGE_TITLE.text);

        //check characteristics of the central block title-links
        homePage.checkPageLinks();
    }
}
