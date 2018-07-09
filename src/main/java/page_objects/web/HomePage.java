package page_objects.web;

import enums.driverSetup.MaskPrefix_Enum;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utile.ReadProperties;

import static enums.driverSetup.MaskPrefix_Enum.HTTPS_PREFIX;
import static enums.driverSetup.MaskPrefix_Enum.HTTP_PREFIX;
import static enums.web.Iana_org_Enum.*;
import static setup.DriverSetup.getDriver;
import static setup.DriverSetup.getWebDriverWait;

public class HomePage extends WebPage {
  private WebElement domainNamesLink;
  private WebElement numberResourcesLink;

  Properties properties = ReadProperties.getCurrentProp("/properties_web/iana_org.properties");

  /**
   * check the url after driver navigation.
   */
  @Override
  public void checkUrl(String urlTitle) {

    getWebDriverWait().until(ExpectedConditions.urlToBe(HTTP_PREFIX.text + properties.getProperty(HOME_LINK.text)));
    Assert.assertEquals(getDriver().getTitle(), urlTitle);
  }

  /**
   * check links functionality for 2 big blocks(DOMAIN_LINK, NUMBER_RESOURCES_LINK).
   * -check title name & other specifications of elements
   */
  public void checkPageLinks() {
    domainNamesLink = getDriver().findElementByCssSelector("#home-panel-domains a");
    numberResourcesLink = getDriver().findElementByCssSelector("#home-panel-numbers a");

    //check titles of blocks
    Assert.assertEquals(domainNamesLink.getText(), properties.getProperty(DOMAIN_NAMES_TITLE.text));
    Assert.assertEquals(numberResourcesLink.getText(), properties.getProperty(NUMBER_RESOURCES_TITLE.text));

    //DOMAIN_LINK block activity check
    checkLinkActivityOnClick(getDriver().findElementByCssSelector("#home-panel-domains a"), new WebPage(),
        HTTPS_PREFIX.text + properties.getProperty(DOMAIN_LINK.text));
    getDriver().get(MaskPrefix_Enum.HTTPS_PREFIX.text + properties.getProperty(HOME_LINK.text));
    getWebDriverWait().until(ExpectedConditions.urlToBe(HTTPS_PREFIX.text + properties.getProperty(HOME_LINK.text)));
    //NUMBER_RESOURCES_LINK block
    checkLinkActivityOnClick(getDriver().findElementByCssSelector("#home-panel-numbers a"),
        new WebPage(), HTTPS_PREFIX.text + properties.getProperty(NUMBER_RESOURCES_LINK.text));
    getDriver().get(MaskPrefix_Enum.HTTPS_PREFIX.text + properties.getProperty(HOME_LINK.text));
    getWebDriverWait().until(ExpectedConditions.urlToBe(HTTPS_PREFIX.text + properties.getProperty(HOME_LINK.text)));
  }

  /**
   * check links functionality.
   * -click
   * -move to other page
   * -check the link
   * -back to HOME_LINK page
   */
  private void checkLinkActivityOnClick(WebElement element, WebPage page, String url) {
    Assert.assertTrue(element.isDisplayed(), element.getText() + " is invisible!");
    Assert.assertTrue(element.isEnabled(), element.getText() + "   isn`t enabled!");
    element.click();
    getWebDriverWait().until(ExpectedConditions.urlToBe(url));
    page.checkUrl(url);
    //wait the page-loading for the correct work with next elements

  }
}
