import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts;
    private static Scanner sc;

    public static void main(String[] args) {

        contacts = new ArrayList<>();
        showMainMenu();
        sc = new Scanner(System.in);
        int mainMenuChoice = sc.nextInt();

        switch(mainMenuChoice) {

            case 1:
                showManageContactsMenu();
                break;
            case 2:
                showManageMessagesMenu();
                mainMenuChoice = sc.nextInt();
                break;
            default:
                break;
        }
    }

    private static void showMainMenu() {
        System.out.println("Greetings. Please select an option from the main menu:");
        System.out.println("\t1. Manage Contacts" +
                           "\n\t2. Messages" +
                           "\n\t3. Quit");
    }

    private static void showManageContactsMenu() {
        System.out.println("Manage Contacts:");
        System.out.println("\t1. Show all contacts");
        System.out.println("\t2. Add a new contact");
        System.out.println("\t3. Search for a contact");
        System.out.println("\t4. Delete a contact");
        System.out.println("\t5. Back to previous menu");
        int contactChoice = sc.nextInt();

        switch(contactChoice) {
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                searchContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showManageContactsMenu();
                break;
        }
    }

    public static void showAllContacts() {
        for(Contact c : contacts) {
            c.getDetails();
        }
        showManageContactsMenu();
    }
    private static void deleteContact() {
        System.out.println("Please enter the name: ");
        String name = sc.next();

        if(name.equals("")) {
            System.out.println("Invalid entry. Field(s) cannot be blank.");
            deleteContact();
        } else {
            boolean doesExist = false;
            for(Contact c : contacts) {
                if(c.getName().equals(name)) {
                    doesExist = true;
                    contacts.remove(c);
                }
            }
            if(!doesExist) {
                System.out.println("Contact does not exist.");
            }
        }
        showMainMenu();
    }

    private static void searchContact() {
        System.out.println("Please enter the contact name.");
        String name = sc.next();
        if(name.equals("")) {
            System.out.println("Invalid entry. Field(s) cannot be blank.");
            searchContact();
        } else {
            boolean doesExist = false;
            for(Contact c : contacts) {
                if(c.getName().equals(name)) {
                    doesExist = true;
                    c.getDetails();
                }
            }
            if(!doesExist) {
                System.out.println("Contact does not exist.");
                searchContact();
            }
        }
        showMainMenu();
    }

    private static void addNewContact() {
        System.out.println("Adding a new contact...");
        System.out.println("Please enter the contact's name: ");
        String name = sc.next();
        System.out.println("Please enter the contact's number: ");
        String number = sc.next();
        System.out.println("Please enter the contact's email: ");
        String email = sc.next();

        if(name.equals("") || number.equals("") || email.equals("")) {
            System.out.println("Invalid entry. Field(s) cannot be blank.");
            addNewContact();
        } else {
            Contact contact = new Contact(name, number, email);
            contacts.add(contact);
        }
        showMainMenu();
    }

    private static void showManageMessagesMenu() {
        System.out.println("Messages:");
        System.out.println("\t1. See the list of all messages");
        System.out.println("\t2. Send a new message");
        System.out.println("\t3. Back to previous menu");
        int messageChoice = sc.nextInt();

        switch(messageChoice) {

        }
    }


}
