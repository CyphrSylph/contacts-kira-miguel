package contactApp;

import java.util.ArrayList;
import java.util.List;

public class ContactList {

    // Private field containing ArrayList of contact items
    private ArrayList<Contact> contacts;

    // Method to create a new contact list
    public ContactList() {
        contacts = new ArrayList<>();
    }

    // Method to add a contact to list
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // Method to remove contact from list
    public void removeContact(String contactName) {
        int index = getContactIndex(contactName);
        if(index > -1) {
            contacts.remove(index);
        }
    }

    // Method to get index of contact from arrayList based on name
    private int getContactIndex(String contactName) {
        int index = -1;
        for(int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            String contactInList = contact.getName();
            if(contactInList.equalsIgnoreCase(contactName)) {
                return i;
            }
        }
        return index;
    }

    // Method to set the contact phone number based on name
    public void setPhoneNum(String contactName, String phoneNum) {
        int index = getContactIndex(contactName);
        if(index > -1) {
            Contact contact = contacts.get(index);
            contact.setPhoneNum(phoneNum);
        }
    }

    // Method to get contact info [phone num included] based on name
    public Contact getContactName(String contactName) {
        int index = getContactIndex(contactName);
        if(index > -1) {
            return contacts.get(index);
        }
        System.out.println("Contact not found" + contactName);
        return null;
    }

    // Method to print contact list
    public void printContacts() {
        System.out.println("Contact List");
        for(Contact contact: contacts) {
            System.out.println("\t" + contact);
        }
    }

    //
    public List<String> toStringList() {
        List<String> contactStrings = new ArrayList<>();
        for(Contact contact : contacts) {
            contactStrings.add(contact.toString());
        }
        return contactStrings;
    }

}