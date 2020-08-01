package course.battlegame.gameengine.transactions;

public class ReplyTransaction extends InfoTransaction {
    private Transaction transaction;
    private Boolean isExecutedTransaction;

    public ReplyTransaction(String message, Transaction transaction, Boolean isExecuted) {
        super(message);
        this.transaction = transaction;
        this.isExecutedTransaction = isExecuted;
    }

    public Boolean getExecuted() {
        return isExecutedTransaction;
    }

    public Transaction getErrorTransaction() {
        return transaction;
    }
}
