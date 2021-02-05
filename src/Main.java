import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts;
    private static Scanner sc;
    private static int id = 0;

    public static void main(String[] args) {

        contacts = new ArrayList<>();
        showInitialOptions();
        sc = new Scanner(System.in);
        int mainMenuChoice = sc.nextInt();

        switch (mainMenuChoice) {

            case 1:
                manageContacts();
                break;
            case 2:
                manageMessages();
                break;
            default:
                showInitialOptions();
                break;
        }
    }

    private static void showInitialOptions() {
        System.out.println("Greetings. Please select an option from the main menu:");
        System.out.println("\t1. Manage Contacts" +
                "\n\t2. Messages" +
                "\n\t3. Quit");
    }

    private static void manageContacts() {
        System.out.println("Manage Contacts:");
        System.out.println("\t1. Show all contacts");
        System.out.println("\t2. Add a new contact");
        System.out.println("\t3. Search for a contact");
        System.out.println("\t4. Delete a contact");
        System.out.println("\t5. Back to previous menu");
        int contactChoice = sc.nextInt();

        switch (contactChoice) {
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
                showInitialOptions();
                break;
        }
    }

    public static void showAllContacts() {
        for (Contact c : contacts) {
            c.getDetails();
            System.out.println("************************");
        }
        showInitialOptions();
    }

    private static void deleteContact() {
        System.out.println("Please enter the name: ");
        String name = sc.next();

        if (name.equals("")) {
            System.out.println("Invalid entry. Field(s) cannot be blank.");
            deleteContact();
        } else {
            boolean doesExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                    contacts.remove(c);
                }
            }
            if (!doesExist) {
                System.out.println("Contact does not exist.");
            }
        }
        showInitialOptions();
    }

    private static void searchContact() {
        System.out.println("Please enter the contact name.");
        String name = sc.next();
        if (name.equals("")) {
            System.out.println("Invalid entry. Field(s) cannot be blank.");
            searchContact();
        } else {
            boolean doesExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                    c.getDetails();
                }
            }
            if (!doesExist) {
                System.out.println("Contact does not exist.");
                searchContact();
            }
        }
        showInitialOptions();
    }

    private static void addNewContact() {
        System.out.println("Adding a new contact...");
        System.out.println("***********************");
        System.out.println("Please enter the contact's name: ");
        String name = sc.next();
        System.out.println("Please enter the contact's number: ");
        String number = sc.next();
        System.out.println("Please enter the contact's email: ");
        String email = sc.next();

        if (name.equals("") || number.equals("") || email.equals("")) {
            System.out.println("Invalid entry. Field(s) cannot be blank.");
            addNewContact();
        } else {
            boolean doesExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name) && c.getNumber().equals(number) && c.getEmail().equals(email)) {
                    doesExist = true;
                }
            }
            if (doesExist) {
                System.out.println("Contact already exists");
                addNewContact();
            } else {
                Contact contact = new Contact(name, number, email);
                contacts.add(contact);
                System.out.println(name + " added successfully.");
            }

        }
        showInitialOptions();
    }

    private static void manageMessages() {
        System.out.println("Messages:");
        System.out.println("\t1. See the list of all messages");
        System.out.println("\t2. Send a new message");
        System.out.println("\t3. Back to previous menu");
        int messageChoice = sc.nextInt();

        switch (messageChoice) {
            case 1:
                showAllMessages();
                break;
            case 2:
                sendNewMessage();
                break;
            default:
                showInitialOptions();
        }
    }


    private static void sendNewMessage() {
        System.out.println("Please enter the recipients name: ");
        String name = sc.next();
        boolean doesExist = false;
        if(name.equals("")) {
            System.out.println("Please enter the name of the contact.");
            sendNewMessage();
        } else {

            for(Contact c : contacts) {
                if(c.getName().equals(name));
                doesExist = true;
            }
        }
        if(doesExist) {
            System.out.println("Please enter the message: ");
            String messageText = sc.next();
            if(messageText.equals("")) {
                System.out.println("Please enter a valid message.");
                sendNewMessage();
            } else {
                id++;                                                       // guarantee the id is unique for every message
                Message newMessage = new Message(messageText, name, id);
                for(Contact c : contacts) {
                    if(c.getName().equals(name)) {
                        ArrayList<Message> newMessages = c.getMessages();   // copy the old list to the new
                        newMessages.add(newMessage);                        // then add the new messages
                        Contact currentContact = c;                         // assign currentContact to new c of contact
                        currentContact.setMessages(newMessages);            // set the new message to the currentContact
                        contacts.remove(c);                                 // remove old c from contacts to make way for the new currentContact with the new messages
                        contacts.add(currentContact);                       // place the new contact in with the new messages
                    }
                }
            }
        } else {
            System.out.println("Contact does not exist.");
        }
        showInitialOptions();
    }

    private static void showAllMessages() {
        ArrayList<Message> allMessages = new ArrayList<>();
        for (Contact c : contacts) {
            allMessages.addAll(c.getMessages());
        }

        if (allMessages.size() > 0) {
            for (Message m : allMessages) {
                m.getDetails();
                System.out.println("*******************");
            }
        } else {
            System.out.println("There are no messages.");
        }
        showInitialOptions();
    }
}


