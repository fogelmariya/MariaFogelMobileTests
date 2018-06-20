1.	For existing native mobile autotest try to use another locator (xpath, classname, ?).
Define these locators using Appium Inspector. Are there any difference with id version?

All this ways to get locator are similar to each other, but the AccessibilityId name is the shortest.
2. Modify existing tests to run on a real device. What should be changed?

   Set a new deviceName to DesiredCapabilities.

3. Connect a real device to Appium (describe required actions) and run tests.
   Are there any difference with run on emulator?

   It is slower

4.	What should be improved/changed in existing test code? Why, for what?

We need to:
-add page objects
-add the checking-functions
-remove hardcode with paths

