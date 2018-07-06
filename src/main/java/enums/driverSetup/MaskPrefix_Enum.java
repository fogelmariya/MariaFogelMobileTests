package enums.driverSetup;

public enum MaskPrefix_Enum {
    URL_MASK("sut"),
    HTTP_PREFIX("http://"),
    HTTPS_PREFIX("https://"),
    APP_MASK("app"),
    HOST_MASK("host");

    public final String text;

    MaskPrefix_Enum(String text) {
        this.text = text;
    }
}
