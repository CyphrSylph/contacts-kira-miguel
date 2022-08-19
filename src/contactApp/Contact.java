package contactApp;

public class Contact {
    // Private variables for contact item
    private String name;
    private String phoneNum;

    // Constructor for contact variables
    public Contact(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }

    // Create contact item from string
    public static Contact createString(String contactString) {
        String [] parts = contactString.split("-");
        return new Contact(parts[0],(parts[1]));
    }

    // Set String format for contact information
    @Override
    public String toString() {
        return name + ":" + phoneNum;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

}