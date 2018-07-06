package enums.driverSetup;

public enum Properties_Enum {
    NATIVES_PROPERTY("/properties_native/native_test.properties"),

    WEB_PROPERTY("/properties_web/web_test.properties");

    public String text;

    Properties_Enum(String text) {
        this.text = text;
    }
}
