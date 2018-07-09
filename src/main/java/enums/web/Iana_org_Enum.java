package enums.web;

public enum Iana_org_Enum {

    HOME_LINK("home_link"),
    DOMAIN_LINK("domain_link"),
    NUMBER_RESOURCES_LINK("mumber_resources_link"),

    HOME_PAGE_TITLE("home_page_title"),
    DOMAIN_NAMES_TITLE("domain_names_title"),
    NUMBER_RESOURCES_TITLE("number_resources_title");

    public String text;

    Iana_org_Enum(String text) {
        this.text = text;
    }
}
