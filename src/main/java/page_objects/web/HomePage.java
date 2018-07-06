package page_objects.web;

import enums.driverSetup.CommonInfoEnum;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static enums.driverSetup.CommonInfoEnum.HTTPS_PREFIX;
import static enums.driverSetup.CommonInfoEnum.HTTP_PREFIX;
import static enums.web.SitePageEnum.DOMAIN_LINK;
import static enums.web.SitePageEnum.DOMAIN_NAMES_TITLE;
import static enums.web.SitePageEnum.HOME_LINK;
import static enums.web.SitePageEnum.NUMBER_RESOURCES_LINK;
import static enums.web.SitePageEnum.NUMBER_RESOURCES_TITLE;
import static enums.web.SitePageEnum.PROTOCOL_ASSIGNMENTS_TITLE;
import static setup.DriverSetup.getDriver;
import static setup.DriverSetup.getWebDriverWait;

public class HomePage extends WebPage {
  private WebElement domainNamesLink;
  private WebElement numberResourcesLink;
  private WebElement protocolAssignmentsLink;


  /**
   * check the url after driver navigation.
   *
   */
  @Override
  public void checkUrl(String urlTitle) {

    getWebDriverWait().until(ExpectedConditions.urlToBe(HTTP_PREFIX.text + HOME_LINK.text));
    Assert.assertEquals(getDriver().getTitle(), urlTitle);
  }

  /**
   * check links functionality for 3 big blocks(DOMAIN_LINK, NUMBER_RESOURCES_LINK, PROTOCOL).
   * -check title name & other specifications of elements
   */
  public void checkPageLinks() {
    domainNamesLink = getDriver().findElementByCssSelector("#home-panel-domains a");
    numberResourcesLink = getDriver().findElementByCssSelector("#home-panel-numbers a");
    protocolAssignmentsLink = getDriver().findElementByCssSelector("#home-panel-protocols a");

    //check titles of blocks
    Assert.assertEquals(domainNamesLink.getText(), DOMAIN_NAMES_TITLE.text);
    Assert.assertEquals(numberResourcesLink.getText(), NUMBER_RESOURCES_TITLE.text);
    Assert.assertEquals(protocolAssignmentsLink.getText(), PROTOCOL_ASSIGNMENTS_TITLE.text);

    //DOMAIN_LINK block activity check
    checkLinkActivityOnClick(getDriver().findElementByCssSelector("#home-panel-domains a"), new DomainPage(),
        HTTPS_PREFIX.text + DOMAIN_LINK.text);
    //NUMBER_RESOURCES_LINK block
    checkLinkActivityOnClick(getDriver().findElementByCssSelector("#home-panel-numbers a"),
        new NumberResourcesPage(), HTTPS_PREFIX.text + NUMBER_RESOURCES_LINK.text);
  }

  /**
   * check links functionality.
   * -element is visible
   * -element is enabled
   * -click
   * -move to other page
   * -check the link
   * -back to HOME_LINK page
   */
  private void checkLinkActivityOnClick(WebElement element, WebPage page, String url) {
    Assert.assertTrue( element.isDisplayed(), element.getText() + " is invisible!");
    Assert.assertTrue( element.isEnabled(), element.getText() + "   isn`t enabled!");
    element.click();
    getWebDriverWait().until(ExpectedConditions.urlToBe(url));
    page.checkUrl(url);
    //wait the page-loading for the correct work with next elements
    getWebDriverWait().until(ExpectedConditions.urlToBe(HTTPS_PREFIX.text + HOME_LINK.text));
  }
}
