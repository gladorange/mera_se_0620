package main.transactions;

public class InfoTransaction extends Transaction {
    private String message;

    public InfoTransaction(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
