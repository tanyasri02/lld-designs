package splitwise;

public class Expense {
    private int id;
    private double amount;
    private String name;
    private User paidByUser;
    private Group group;

    public Expense(int id, double amount, String name, User paidByUser, Group group){
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.paidByUser = paidByUser;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public Group getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public User getPaidByUser() {
        return paidByUser;
    }
}
