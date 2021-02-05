import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contact {

    private String name;
    private String number;
    private String email;
    private ArrayList<Message> messages = new ArrayList<>();


    public Contact(String name, String number, String email, ArrayList messages) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.messages = messages;
    }

    public Contact(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.messages = new ArrayList<>();
    }

    public void getDetails() {
        System.out.println("Contact name: " + this.name +
                "\nNumber: " + this.number + "" +
                "\nEmail: " + this.email + "" +
                "\nMessages: " + this.messages);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Contact:\n " +
                "\tname: \n" + name +
                "\tnumber: \n" + number + '\'' +
                "\temail: " + email + '\'' +
                '}';
    }
}
