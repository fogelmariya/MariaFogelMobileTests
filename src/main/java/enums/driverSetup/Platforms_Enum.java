package enums.driverSetup;

public enum Platforms_Enum {
    PLATFORM_MASK("platformName"),
    ANDROID("Android"),
    IOS("iOS"),
    UNKNOWN_PLATFORM("Unknown platform");

   public final String text;

    Platforms_Enum(String text) {
        this.text = text;
    }
}
