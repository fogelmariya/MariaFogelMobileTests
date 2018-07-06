package enums.driverSetup;

public enum Browsers_Enum {
    BROWSER_MASK("browserName"),
    CHROME("Chrome"),
    SAFARI("Safari");

    public final String text;

    Browsers_Enum(String text) {
        this.text = text;
    }
}
