package splitwise;

public class Settlement {
    private int id;
    private User fromUser;
    private User toUser;
    private double amount;
    private SettlementStatus status;

    public Settlement(int id, User fromUser, User toUser, double amount, SettlementStatus status){
        this.id = id;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.amount = amount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public SettlementStatus getStatus() {
        return status;
    }

    public User getFromUser() {
        return fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setStatus(SettlementStatus settlementStatus) {
        this.status = settlementStatus;
    }
}
