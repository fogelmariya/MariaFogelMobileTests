package scenarios.hw2;

import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSetup {
  protected AndroidDriver driver;

  /**
   * Set of capabilities to test Android native app
   * @throws MalformedURLException
   */


  protected void prepareNative() throws MalformedURLException { // exception required by java.net.URL
    DesiredCapabilities capabilities = new DesiredCapabilities();
    //mandatory capabilities
    //capabilities.setCapability("deviceName","emulator-5554");

    //capability for virtual device from genymotion
    //capabilities.setCapability("deviceName","192.168.105.101:5555");

    //capability for real device
    capabilities.setCapability("deviceName","HA0LX0QW");
    capabilities.setCapability("platformName","Android");


    File appDir = new File("D:\\IntellijProjects\\MariaFogel\\src\\main\\resources");
    File app = new File(appDir, "contactmanager.apk");

    //other caps
    capabilities.setCapability("app", app.getAbsolutePath());

    // Init driver for local Appium server with capabilities have been set
    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

  }

  /**
   * Set of capabilities to test Android web app
   * @throws MalformedURLException
   */


  protected void prepareAndroidWeb() throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    //mandatory Android capabilities
    capabilities.setCapability("deviceName","192.168.105.101:5555");
    //capabilities.setCapability("deviceName","emulator-5554");
    capabilities.setCapability("platformName","Android");

    // specific web capabilities
    capabilities.setCapability("browserName", "Chrome");
    //capabilities.setCapability("browserName", "Browser");

    // Init driver for local Appium server with capabilities have been set
    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
   // driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),
        //capabilities);


  }


}

