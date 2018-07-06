package setup;

import io.appium.java_client.AppiumDriver;
import java.io.File;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ReadProperties;

import static enums.driverSetup.BrowsersEnum.BROWSER_MASK;
import static enums.driverSetup.BrowsersEnum.CHROME;
import static enums.driverSetup.BrowsersEnum.SAFARI;
import static enums.driverSetup.CommonInfoEnum.APP_MASK;
import static enums.driverSetup.CommonInfoEnum.HOST_MASK;
import static enums.driverSetup.CommonInfoEnum.URL_MASK;
import static enums.driverSetup.CommonInfoEnum.HTTP_PREFIX;
import static enums.driverSetup.PlatformsEnum.ANDROID;
import static enums.driverSetup.PlatformsEnum.IOS;
import static enums.driverSetup.PlatformsEnum.PLATFORM_MASK;
import static enums.driverSetup.PlatformsEnum.UNKNOWN_PLATFORM;

public class DriverSetup {
  private static DriverSetup ourInstance = new DriverSetup();
  private static DesiredCapabilities capabilities;
  private static Properties properties;
  private static AppiumDriver driver;
  private static WebDriverWait webDriverWait;
  private static String url;

  private DriverSetup() {
  }

  public static AppiumDriver getDriver() {
    return driver;
  }

  public static WebDriverWait getWebDriverWait() {
    return webDriverWait;
  }

  public static String getUrl() {
    return url;
  }

  public static DriverSetup getInstance() {
    return ourInstance;
  }

  /**
   * configure & init AppiumDriver
   */
  static public void prepareDriver(String property) throws Exception {
    properties = ReadProperties.getCurrentProp(property);
    capabilities = new DesiredCapabilities();
    if (properties != null) {
      if (properties.containsKey(URL_MASK.text)) {
        url = HTTP_PREFIX.text + properties.getProperty(URL_MASK.text);
        if (properties.getProperty(PLATFORM_MASK.text).equalsIgnoreCase(ANDROID.text)) {
          properties.setProperty(BROWSER_MASK.text, CHROME.text);
        } else if (properties.getProperty(PLATFORM_MASK.text).equalsIgnoreCase(IOS.text)) {
          properties.setProperty(BROWSER_MASK.text, SAFARI.text);
        } else {
          throw new Exception(UNKNOWN_PLATFORM.text);
        }
      } else if (properties.containsKey(APP_MASK.text)) {
        properties.setProperty(APP_MASK.text, new File(properties.getProperty(APP_MASK.text))
            .getAbsolutePath());
      }
      properties.forEach((key, value) -> {
        if (!key.toString().equalsIgnoreCase(URL_MASK.text) && !key.toString().equalsIgnoreCase(HOST_MASK.text)) {
          capabilities.setCapability((String) key, (String) value);
        }
      });
    }
    driver = new AppiumDriver(new URL(properties.getProperty(HOST_MASK.text)),
        capabilities);
    webDriverWait = new WebDriverWait(driver, 25);
  }
}
