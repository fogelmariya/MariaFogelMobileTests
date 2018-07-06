package page_objects.web;

import enums.driverSetup.MaskPrefix_Enum;
import org.testng.Assert;

import static enums.web.Iana_org_Enum.HOME_LINK;
import static setup.DriverSetup.getDriver;

public class WebPage {
    /**
     * uses to check the url after driver navigation.
     *
     * @param url - expected  new url
     */
    public void checkUrl(String url) {
        Assert.assertEquals(url, getDriver().getCurrentUrl());
        getDriver().get(MaskPrefix_Enum.HTTPS_PREFIX.text + HOME_LINK.text);
    }
}
