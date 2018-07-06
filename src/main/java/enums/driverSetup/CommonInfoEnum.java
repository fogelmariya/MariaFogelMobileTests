package enums.driverSetup;

public enum CommonInfoEnum {
    URL_MASK("sut"),
    HTTP_PREFIX("http://"),
    HTTPS_PREFIX("https://"),
    APP_MASK("app"),
    HOST_MASK("host");

    public final String text;

    CommonInfoEnum(String text) {
        this.text = text;
    }
}
