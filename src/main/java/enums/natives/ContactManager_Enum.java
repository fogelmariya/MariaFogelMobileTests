package enums.natives;

public enum ContactManager_Enum {
    CONTACT_NAME("Contact Name", "Paul"),
    CONTACT_PHONE("Contact Phone", "+310 567 45 67"),
    CONTACT_EMAIL("Contact Email", "Pauly@gmail.com");

    public String user;
    public String text;

    ContactManager_Enum(String text, String user) {
        this.user = user;
        this.text = text;
    }
}
