package scenarios.hw3.web;

import enums.web.Iana_org_Enum;
import java.util.Properties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.web.HomePage;
import setup.DriverSetup;
import utile.ReadProperties;

import static enums.driverSetup.Properties_Enum.WEB_PROPERTY;
import static setup.DriverSetup.getDriver;
import static setup.DriverSetup.getUrl;

public class IanaWebPageTest {
  HomePage homePage;
  Properties properties = ReadProperties.getCurrentProp("/properties_web/iana_org.properties");

  /**
   * prepare AppiumDriver
   */
  @BeforeClass(alwaysRun = true)
  public void setup() {
    try {
      new DriverSetup(WEB_PROPERTY.text);
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
    homePage.checkUrl(properties.getProperty(Iana_org_Enum.HOME_PAGE_TITLE.text));

    //check characteristics of the central block title-links
    homePage.checkPageLinks();
  }
}
