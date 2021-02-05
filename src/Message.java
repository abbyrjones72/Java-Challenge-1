public class Message {

    private String text;
    private String recipient;
    private int id;

    /**
     * Message instance that takes in
     * @param text: String
     * @param recipient: String
     * @param id: int (a unique identifier that is static in Main.java)
     */
    public Message(String text, String recipient, int id) {
        this.text = text;
        this.recipient = recipient;
        this.id = id;
    }

    public void getDetails() {
        System.out.println("Contact name: " + recipient +
                            "\nMessage: " + text + "" +
                            "\nId: " + id);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRecipient() {
        return recipient;
    }

    /**
     * Sets the recipient message
     * @param recipient: String
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
