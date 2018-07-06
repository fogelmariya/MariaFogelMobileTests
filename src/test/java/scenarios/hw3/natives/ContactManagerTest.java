package scenarios.hw3.natives;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.contact_manager.ContactAdditionForm;
import page_objects.contact_manager.ContactInfoForm;

import static enums.driverSetup.TestsSettingsEnum.NATIVES_PROPERTY;
import static setup.DriverSetup.getDriver;
import static setup.DriverSetup.prepareDriver;

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
      prepareDriver(NATIVES_PROPERTY.text);
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
    contactInfoForm.checkPhoneForm();
    contactInfoForm.checkEmailForm();
    contactInfoForm.checkSubmitButton();
  }
}
