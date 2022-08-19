package contactApp;



public class ContactGUI {

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ContactGUI {
    public static final int INVALID_CHOICE = -1;
    public static final int EXIT_CHOICE = 0;


    static HashMap<String, String> listCon = new HashMap<>();

        //method to display menu & get user Input
        public static void displayMenu(ContactList list) {
            Input input = new Input();

            //print menu
            System.out.println("1. View contacts.\n" +
                    "2. Add a new contact.\n" +
                    "3. Search a contact by name.\n" +
                    "4. Delete an existing contact.\n" +
                    "5. Exit.");
        }

    public static void main(String[] args) {
        Input input = new Input();

        ContactList list = ContactPortal.readFile();
        displayMenu(list);

        // loop until the user says he/she does not wish to continue
        int choice = INVALID_CHOICE;
        while(choice != EXIT_CHOICE) {
            displayMenu(list);

            choice = input.getInt(0, 5, "Enter 0 through 5: ");

            doChoice(choice, list);
        }
    }

    private static void doChoice(int choice, ContactList list) {
        switch(choice) {
            case 1: contactList();
                break;
            case 2: addContact();
                break;
            case 3:searchContact();
                break;
            case 4:removeContact();
                break;
            case 5:ContactPortal.writeFile(list);
                System.exit(0);
                break;
        }
    }


    public static void contactList() {
        Contact bob = new Contact("bob", "5555555556");
        Contact john = new Contact("john", "5555555557");

        listCon.put(bob.getName(), bob.getPhoneNum());
        listCon.put(john.getName(), john.getPhoneNum());

        System.out.println(listCon.keySet());

    }

    public static void addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String addName = scanner.nextLine();
        System.out.println("Enter number: ");
        String addPhone = scanner.nextLine();

        Contact newContact = new Contact(addName, addPhone);

        listCon.put(addName,addPhone);

    }

    public static void removeContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name to delete contact: ");
        String removeName = scanner.nextLine();
        if(listCon.containsKey(removeName)) {
            System.out.println("Contact found can be removed.");
            listCon.remove(removeName);
        } else {
            System.out.println("Contact does not exist.");
        }

    }

    public static void searchContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name to search.");
        String searchName = scanner.nextLine();
        if(listCon.containsKey(searchName)) {
            System.out.println(listCon.get(searchName));
        } else {
            System.out.println("Contact does not exist.");
        }
    }



}
