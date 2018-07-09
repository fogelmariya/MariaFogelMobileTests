package scenarios.hw3.natives;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.contact_manager.ContactAdditionForm;
import page_objects.contact_manager.ContactInfoForm;
import setup.DriverSetup;

import static enums.driverSetup.Properties_Enum.NATIVES_PROPERTY;
import static setup.DriverSetup.getDriver;

public class ContactManagerTest {
  ContactAdditionForm contactAdditionForm;
  ContactInfoForm contactInfoForm;

  /**
   *  prepare AppiumDriver
   */
  @BeforeClass(alwaysRun = true)
  public void setup() {
    contactAdditionForm = new ContactAdditionForm();
    contactInfoForm = new ContactInfoForm();
    try {
      new DriverSetup(NATIVES_PROPERTY.text);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * close driver
   */
  @AfterClass(alwaysRun = true)
  public void tearDown() {
    getDriver().closeApp();
    System.out.println("Driver closes application");
  }

  /**
   * checking fields and titles of ContactManager
   */
  @Test(description = "Native test of general functional of ContactManager", groups = "native")
  public void checkContactManager() {
    contactAdditionForm.checkAdditionalButton();

    contactInfoForm.checkFormName();
    contactInfoForm.checkFormPhone();
    contactInfoForm.checkFormEmail();
    contactInfoForm.checkSubmitButton();
  }
}
