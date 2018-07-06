package page_objects.web;

import enums.driverSetup.CommonInfoEnum;
import org.testng.Assert;

import static enums.web.SitePageEnum.HOME_LINK;
import static setup.DriverSetup.getDriver;

public class WebPage {
    /**
     * uses to check the url after driver navigation.
     *
     * @param url - expected  new url
     */
    public void checkUrl(String url) {
        Assert.assertEquals(url, getDriver().getCurrentUrl());
        getDriver().get(CommonInfoEnum.HTTPS_PREFIX.text + HOME_LINK.text);
    }
}
