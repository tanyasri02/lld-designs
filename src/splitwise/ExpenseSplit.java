package splitwise;

public class ExpenseSplit {
    private int id;
    private Expense expense;
    private User user;
    private double shareAmount;

    public ExpenseSplit(int id, Expense expense, User user, double shareAmount){
        this.id = id ;
        this.expense = expense;
        this.user = user;
        this.shareAmount = shareAmount;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public double getShareAmount() {
        return shareAmount;
    }

    public Expense getExpense() {
        return expense;
    }
}
