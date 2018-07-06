package enums.web;

public enum Iana_org_Enum {

    HOME_LINK("www.iana.org/"),
    DOMAIN_LINK("www.iana.org/domains"),
    NUMBER_RESOURCES_LINK("www.iana.org/numbers"),

    HOME_PAGE_TITLE("Internet Assigned Numbers Authority"),
    DOMAIN_NAMES_TITLE("Domain Names"),
    NUMBER_RESOURCES_TITLE("Number Resources"),
    PROTOCOL_ASSIGNMENTS_TITLE("Protocol Assignments");

    public String text;

    Iana_org_Enum(String text) {
        this.text = text;
    }
}
