package page_objects.contact_manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static enums.natives.ContactManager_Enum.CONTACT_NAME;
import static enums.natives.ContactManager_Enum.CONTACT_PHONE;
import static setup.DriverSetup.getDriver;

public class ContactInfoForm {
  private final String PATH = "com.example.android.contactmanager:id/";
  private final String XPATH = "//android.widget.TextView[@content-desc=";
  private WebElement contactNameTextField;
  private WebElement contactNameTitle;
  private WebElement contactPhoneTextField;
  private WebElement contactPhoneTitle;
  private WebElement contactEmailTextField;
  private WebElement contactEmailTitle;
  private WebElement submitButton;

  /**
   * uses to check the keyboard.
   *
   * - keyboard can be used
   *
   */
  public void checkFieldsWithKeyboard(String text, WebElement webElement) {
    webElement.click();
    getDriver().getKeyboard().sendKeys(text);
    Assert.assertEquals(webElement.getText(), text);
  }

  /**
   * uses to check the Name Field and it`s title.
   *
   */
  public void checkFormName() {
    //title
    contactNameTitle = getDriver().findElement(By.xpath(XPATH + "'Contact Name']"));
    Assert.assertTrue(contactNameTitle.isDisplayed(), "Title of 'Contact Name' text field is invisible");
    Assert.assertEquals(contactNameTitle.getText(), CONTACT_NAME.text);

    //text field
    contactNameTextField = getDriver().findElement(By.id(PATH + "contactNameEditText"));
    Assert.assertTrue(contactNameTextField.isDisplayed(), "Text field 'Contact Name' is invisible");
    Assert.assertTrue(contactNameTextField.isEnabled(), "TText field 'Contact Name' is not enabled");

    //send keys by keyboard
    contactNameTextField.click();
    //checkFieldsWithKeyboard(CONTACT_NAME.user, contactNameTextField);
  }

  /**
   * uses to check the Phone Field and it`s title.
   *
   */
  public void checkFormPhone() {
    //title
    contactPhoneTitle = getDriver().findElement(By.xpath(XPATH + "'Contact Phone']"));
    Assert.assertTrue(contactPhoneTitle.isDisplayed(), "Title of 'Contact Phone' text field is invisible");
    Assert.assertEquals(contactPhoneTitle.getText(), CONTACT_PHONE.text);

    //text field
    contactPhoneTextField = getDriver().findElement(By.id(PATH + "contactPhoneEditText"));
    Assert.assertTrue(contactPhoneTextField.isDisplayed(), "Text field 'Contact Phone' is invisible");

    //send keys by keyboard
    contactPhoneTextField.click();
    //checkFieldsWithKeyboard(CONTACT_PHONE.user, contactPhoneTextField);
  }

  /**
   * uses to check the Phone Field and it`s title.
   *
   */
  public void checkFormEmail() {
    //title
    contactEmailTitle = getDriver().findElement(By.xpath(XPATH + "'Contact Email']"));
    Assert.assertTrue(contactEmailTitle.isDisplayed(),  "Title of 'Contact Phone' text field is invisible");
    //Assert.assertEquals(contactPhoneTitle.getText(), CONTACT_PHONE.text);

    //text field
    contactEmailTextField = getDriver().findElement(By.id(PATH + "contactEmailEditText"));
    Assert.assertTrue(contactEmailTextField.isDisplayed(),  "Text field 'Contact Phone' is invisible");

    //send keys by keyboard
    contactEmailTextField.click();
    //checkFieldsWithKeyboard(CONTACT_EMAIL.user, contactEmailTextField);
  }

  /**
   * uses to check the submit button.
   *
   */
  public void checkSubmitButton() {
    submitButton = getDriver().findElement(By.id(PATH + "contactSaveButton"));
    Assert.assertTrue(submitButton.isDisplayed(),  "Submit button is invisible");
    Assert.assertEquals(submitButton.getText(), "Save");
    Assert.assertTrue(submitButton.isEnabled(),  "Submit button is  not enabled");
    submitButton.click();
  }
}
