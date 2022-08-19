package contactApp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ContactPortal {

    // Method allows new data to be written to file
    public static void writeFile(ContactList contactList) {
        // Create a path object
        Path filePath = getFilePath();
        // If file path is blank
        if(filePath == null) {
            System.out.println("Can't use that path- try another");
            return;
        }
        // Create temporary list of strings containing contacts
        List<String> contactStrings = contactList.toStringList();

        // Send data to file
        stringToFile(filePath, contactStrings);
    }


    // Try-catch validation for writing strings to file
    private static void stringToFile(Path filePath, List<String> contactStrings) {
        try {
            Files.write(filePath, contactStrings);
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // Method allows data to be read from file
    public static ContactList readFile() {
        ContactList list = new ContactList();
        // Create a path object
        Path filePath = getFilePath();
        if(filePath == null) {
            System.out.println("Can't use that path- try another");
            return list;
        }
        // Read item strings from files
        List<String> contactStrings = readStrings(filePath);
        // Create contacts from the strings and add to list
        for(String contactString: contactStrings) {
            Contact contact = Contact.createString(contactString);
            list.addContact(contact);
        }
        return list;
    }


    // Method to read data strings
    public static List<String> readStrings(Path filePath) {
        try {
            return Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // Method to obtain file path for data
    private static Path getFilePath() {
        try {
            Path folder = Paths.get("contact_list");
            Path file = Paths.get("contact_list", "contact.txt");
            if(Files.exists(folder)) {
                System.out.println("Folder created.");
            } else {
                Files.createDirectories(folder);
            }
            if(Files.exists(file)) {
                System.out.println("Update Successful!");
            } else {
                Files.createFile(file);
            }
            return file;
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}